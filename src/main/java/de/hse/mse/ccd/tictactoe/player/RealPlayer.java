package de.hse.mse.ccd.tictactoe.player;

import de.hse.mse.ccd.tictactoe.board.Board;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealPlayer extends Player {

  public RealPlayer(PlayerSymbol symbol) {
    super(symbol);
  }

  @Override
  public Point waitForCellSelection(Board board) {
    System.out.print(
        "Spieler " + symbol + " ist dran: Wo möchtest du dein " + symbol + " setzen? ({x},{y}) ");
    String userInput = waitForUserInput();
    if (!isUserInputInValidFormat(userInput)) {
      System.out.println("Bitte gib das Feld in diesem Format an: ({x},{y})");
      return waitForCellSelection(board);
    }
    Point point = parsePointFromUserInput(userInput);
    if (board.isCellNotSelectable(point)) {
      System.out.println("Das Feld kannst du nicht auswählen.");
      return waitForCellSelection(board);
    }
    return point;
  }

  private Point parsePointFromUserInput(String userInput) {
    String[] split = userInput.split(",");
    int x = Integer.parseInt(split[0]);
    int y = Integer.parseInt(split[1]);
    return new Point(x, y);
  }

  private boolean isUserInputInValidFormat(String userInput) {
    Pattern pattern = Pattern.compile("([0-9]),([0-9])");
    Matcher matcher = pattern.matcher(userInput);
    return matcher.find();
  }

  private String waitForUserInput() {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    try {
      return buffer.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
