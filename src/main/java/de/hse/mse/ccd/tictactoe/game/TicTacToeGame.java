package de.hse.mse.ccd.tictactoe.game;

import de.hse.mse.ccd.tictactoe.board.Board;
import de.hse.mse.ccd.tictactoe.player.ComPlayer;
import de.hse.mse.ccd.tictactoe.player.Player;
import de.hse.mse.ccd.tictactoe.player.PlayerSymbol;
import de.hse.mse.ccd.tictactoe.player.RealPlayer;

public class TicTacToeGame {

  private Player playerA;
  private Player playerB;
  private Board board;

  public void play(GameMode gameMode, int boardSize) {
    initializeGame(gameMode, boardSize);
    board.printBoard();
    Player currentPlayer = playerA;
    while (!hasGameEnded()) {
      board.selectCell(currentPlayer.getSymbol(), currentPlayer.waitForCellSelection(board));
      board.printBoard();
      currentPlayer = currentPlayer == playerA ? playerB : playerA;
    }
  }

  private void initializeGame(GameMode gameMode, int boardSize) {
    board = new Board(boardSize);
    board.initialize();

    playerA = switch (gameMode) {
      case ONE_PLAYER, TWO_PLAYER -> new RealPlayer(PlayerSymbol.X);
      case ONLY_COM -> new ComPlayer(PlayerSymbol.X);
    };
    new RealPlayer(PlayerSymbol.X);
    playerB = switch (gameMode) {
      case ONE_PLAYER, ONLY_COM -> new ComPlayer(PlayerSymbol.O);
      case TWO_PLAYER -> new RealPlayer(PlayerSymbol.O);
    };
  }

  private boolean hasGameEnded() {
    if (board.hasPlayerWon(playerA.getSymbol())) {
      System.out.println("Spieler " + playerA.getSymbol() + " hat gewonnen.");
      return true;
    }
    if (board.hasPlayerWon(playerB.getSymbol())) {
      System.out.println("Spieler " + playerA.getSymbol() + " hat gewonnen.");
      return true;
    }
    if (board.getEmptyCellCount() <= 0) {
      System.out.println("Das war ein Unentschieden.");
      return true;
    }
    return false;
  }

}
