package de.hse.mse.ccd.tictactoe;

import de.hse.mse.ccd.tictactoe.game.TicTacToeGame;
import de.hse.mse.ccd.tictactoe.game.GameMode;

public class Application {

  public static void main(String[] args) {
    TicTacToeGame ticTacToe = new TicTacToeGame();
    ticTacToe.play(GameMode.ONE_PLAYER, 3);
  }
}
