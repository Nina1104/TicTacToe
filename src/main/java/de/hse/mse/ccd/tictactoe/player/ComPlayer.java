package de.hse.mse.ccd.tictactoe.player;

import de.hse.mse.ccd.tictactoe.board.Board;
import java.awt.Point;
import java.util.Random;

public class ComPlayer extends Player {

  public static final int WAITING_TIME = 1;
  private final Random random = new Random();

  public ComPlayer(PlayerSymbol symbol) {
    super(symbol);
  }

  @Override
  public Point waitForCellSelection(Board board) {
    System.out.println("Com Spieler " + symbol + " ist dran...");
    // Wait to simulate player thinking
    waitForSeconds(WAITING_TIME);
    int chosenCellX = -1;
    int chosenCellY = -1;
    while (board.isCellNotSelectable(new Point(chosenCellX, chosenCellY))) {
      chosenCellX = random.nextInt(board.getSize());
      chosenCellY = random.nextInt(board.getSize());
    }
    return new Point(chosenCellX, chosenCellY);
  }

  private static void waitForSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
