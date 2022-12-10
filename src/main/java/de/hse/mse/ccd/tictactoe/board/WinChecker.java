package de.hse.mse.ccd.tictactoe.board;

import de.hse.mse.ccd.tictactoe.player.PlayerSymbol;
import java.util.Arrays;

public class WinChecker {

  public boolean hasPlayerWon(PlayerSymbol player, PlayerSymbol[][] board) {
    return checkHorizontals(player, board) || checkVerticals(player, board) || checkDiagonals(
        player, board);
  }

  private boolean checkHorizontals(PlayerSymbol player, PlayerSymbol[][] board) {
    return Arrays.stream(board).anyMatch(e -> Arrays.stream(e).allMatch(player::equals));
  }

  private boolean checkVerticals(PlayerSymbol player, PlayerSymbol[][] board) {
    boolean allTheSame;
    for (int y = 0; y < board.length; y++) {
      allTheSame = true;
      for (int x = 0; x < board.length; x++) {
        if (!board[x][y].equals(player)) {
          allTheSame = false;
          break;
        }
      }
      if (allTheSame) {
        return true;
      }
    }
    return false;
  }

  private boolean checkDiagonals(PlayerSymbol player, PlayerSymbol[][] board) {
    return checkRightDiagonal(player, board) || checkLeftDiagonal(player, board);
  }

  private boolean checkRightDiagonal(PlayerSymbol player, PlayerSymbol[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (!board[i][i].equals(player)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkLeftDiagonal(PlayerSymbol player, PlayerSymbol[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (!board[i][board.length - i - 1].equals(player)) {
        return false;
      }
    }
    return true;
  }
}