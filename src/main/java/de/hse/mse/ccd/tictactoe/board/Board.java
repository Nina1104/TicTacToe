package de.hse.mse.ccd.tictactoe.board;

import de.hse.mse.ccd.tictactoe.player.PlayerSymbol;
import java.awt.Point;

public class Board {

  private final int size;
  private PlayerSymbol[][] board;
  private final WinChecker winChecker = new WinChecker();

  public Board(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }

  public void initialize() {
    board = new PlayerSymbol[size][size];
    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        board[x][y] = PlayerSymbol.NONE;
      }
    }
  }

  public void selectCell(PlayerSymbol player, Point position) {
    if (isCellNotSelectable(position)) {
      throw new IllegalArgumentException("Diese Zelle ist nicht auswählbar");
    }
    board[position.x][position.y] = player;
  }

  public boolean hasPlayerWon(PlayerSymbol player) {
    return winChecker.hasPlayerWon(player, board);
  }

  public int getEmptyCellCount() {
    int count = 0;
    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        if (board[x][y] == PlayerSymbol.NONE) {
          count++;
        }
      }
    }
    return count;
  }

  public boolean isCellNotSelectable(Point point) {
    if (point.x >= size || point.x < 0 || point.y >= size || point.y < 0) {
      return true;
    }
    return board[point.x][point.y] != PlayerSymbol.NONE;
  }

  public void printBoard() {
    System.out.println();
    System.out.print("   ");
    for (int y = 0; y < size; y++) {
      System.out.print(y + " ");
    }
    System.out.println();
    for (int x = 0; x < size; x++) {
      System.out.print(x + " |");
      for (int y = 0; y < size; y++) {
        System.out.print(board[x][y].label + "|");
      }
      System.out.println();
    }
    System.out.println();
  }
}
