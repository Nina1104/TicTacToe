package de.hse.mse.ccd.tictactoe.board;

import de.hse.mse.ccd.tictactoe.player.PlayerSymbol;
import java.awt.Point;

public class Board {

  private final int size;
  private final PlayerSymbol[][] board;

  public Board(int size) {
    this.size = size;
    this.board = new PlayerSymbol[size][size];
  }

  public int getSize() {
    return this.size;
  }

  public PlayerSymbol[][] getBoard() {
    return board;
  }

  public void selectCell(PlayerSymbol player, Point position) {
    if (!this.isCellSelectable(position)) {
      throw new IllegalArgumentException("Diese Zelle ist nicht auswählbar");
    }
    this.board[position.x][position.y] = player;
  }

  public boolean hasEmptyCells() {
    for (int x = 0; x < this.size; x++) {
      for (int y = 0; y < this.size; y++) {
        if (this.board[x][y] == null) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isCellSelectable(Point point) {
    if (point.x >= this.size && point.x < 0 && point.y >= this.size && point.y < 0) {
      return false;
    }
    return this.board[point.x][point.y] == null;
  }

  public void printBoard() {
    System.out.println();
    System.out.print("   ");
    for (int y = 0; y < this.size; y++) {
      System.out.print(y + " ");
    }
    System.out.println();
    for (int x = 0; x < this.size; x++) {
      System.out.print(x + " |");
      for (int y = 0; y < this.size; y++) {
        System.out.print((this.board[x][y] == null ? " " : this.board[x][y].label) + "|");
      }
      System.out.println();
    }
    System.out.println();
  }
}
