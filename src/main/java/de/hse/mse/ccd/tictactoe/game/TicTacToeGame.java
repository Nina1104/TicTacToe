package de.hse.mse.ccd.tictactoe.game;

import de.hse.mse.ccd.tictactoe.board.Board;
import de.hse.mse.ccd.tictactoe.board.WinChecker;
import de.hse.mse.ccd.tictactoe.player.Player;

public class TicTacToeGame {

  private final Board board;
  private final WinChecker winChecker;
  private final Player playerA;
  private final Player playerB;

  public TicTacToeGame(Player playerA, Player playerB, Board board, WinChecker winChecker) {
    this.board = board;
    this.winChecker = winChecker;
    this.playerA = playerA;
    this.playerB = playerB;
  }

  public void play() {
    Player currentPlayer = playerA;
    while (!this.hasGameEnded()) {
      board.printBoard();
      board.selectCell(currentPlayer.getSymbol(), currentPlayer.getNextCellSelection(board));
      currentPlayer = currentPlayer == playerA ? playerB : playerA;
    }
    board.printBoard();
  }

  private boolean hasGameEnded() {
    if (winChecker.hasPlayerWon(playerA.getSymbol(), board.getBoard())) {
      System.out.println("Spieler " + playerA.getSymbol() + " hat gewonnen.");
      return true;
    }
    if (winChecker.hasPlayerWon(playerB.getSymbol(), board.getBoard())) {
      System.out.println("Spieler " + playerA.getSymbol() + " hat gewonnen.");
      return true;
    }
    if (board.hasEmptyCells()) {
      System.out.println("Das war ein Unentschieden.");
      return true;
    }
    return false;
  }
}
