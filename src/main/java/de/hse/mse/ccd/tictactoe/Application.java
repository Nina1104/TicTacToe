package de.hse.mse.ccd.tictactoe;

import de.hse.mse.ccd.tictactoe.game.TicTacToeGame;
import de.hse.mse.ccd.tictactoe.player.ComPlayer;
import de.hse.mse.ccd.tictactoe.player.PlayerSymbol;
import de.hse.mse.ccd.tictactoe.player.RealPlayer;

public class Application {

  private static final PlayerSymbol PLAYER_A_SYMBOL = PlayerSymbol.X;
  private static final PlayerSymbol PLAYER_B_SYMBOL = PlayerSymbol.O;
  private static final int BOARD_SIZE = 3;

  public static void main(String[] args) {
    System.out.println("Starting TicTacToe...");
    TicTacToeGame ticTacToe = new TicTacToeGame(BOARD_SIZE, new RealPlayer(PLAYER_A_SYMBOL),
        new ComPlayer(PLAYER_B_SYMBOL));
    ticTacToe.play();
  }
}
