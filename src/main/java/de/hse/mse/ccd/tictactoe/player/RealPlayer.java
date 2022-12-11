package de.hse.mse.ccd.tictactoe.player;

import de.hse.mse.ccd.tictactoe.board.Board;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class RealPlayer extends Player {

  private static final Pattern USER_INPUT_PATTERN = Pattern.compile("([0-9]),([0-9])");
  private BufferedReader systemInReader;

  public RealPlayer(PlayerSymbol symbol) {
    super(symbol);
  }

  @Override
  public Point getNextCellSelection(Board board) {
    System.out.print("Spieler " + this.symbol + " ist dran: Wo möchtest du dein " + this.symbol
        + " setzen? ({x},{y}) ");
    String userInput = this.readUserInput();
    if (!this.isUserInputValid(userInput)) {
      System.out.println("Bitte gib das Feld in diesem Format an: ({x},{y})");
      return this.getNextCellSelection(board);
    }

    Point point = this.parsePoint(userInput);
    if (!board.isCellSelectable(point)) {
      System.out.println("Das Feld kannst du nicht auswählen.");
      return this.getNextCellSelection(board);
    }
    return point;
  }

  private Point parsePoint(String input) {
    String[] split = input.split(",");
    int x = Integer.parseInt(split[0]);
    int y = Integer.parseInt(split[1]);
    return new Point(x, y);
  }

  private boolean isUserInputValid(String userInput) {
    return USER_INPUT_PATTERN.matcher(userInput).find();
  }

  private String readUserInput() {
    if (this.systemInReader == null) {
      this.systemInReader = new BufferedReader(new InputStreamReader(System.in));
    }
    try {
      return this.systemInReader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
