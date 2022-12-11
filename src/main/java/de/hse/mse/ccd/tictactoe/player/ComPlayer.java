package de.hse.mse.ccd.tictactoe.player;

import de.hse.mse.ccd.tictactoe.board.Board;

import java.awt.*;
import java.util.Random;

public class ComPlayer extends Player {
  public static final int WAITING_TIME = 1;
  private static final Random RANDOM = new Random();

  public ComPlayer(PlayerSymbol symbol) {
    super(symbol);
  }

  @Override
  public Point getNextCellSelection(Board board) {
    System.out.println("Com Spieler " + this.symbol + " ist dran...");
    // Wait to simulate player thinking
    sleep();
    int chosenCellX;
    int chosenCellY;
    do {
      chosenCellX = RANDOM.nextInt(board.getSize());
      chosenCellY = RANDOM.nextInt(board.getSize());
    } while (!board.isCellSelectable(new Point(chosenCellX, chosenCellY)));

    return new Point(chosenCellX, chosenCellY);
  }

  private static void sleep() {
    try {
      Thread.sleep(ComPlayer.WAITING_TIME * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
