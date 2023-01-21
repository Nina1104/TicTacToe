package de.hse.mse.ccd.tictactoe.game;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hse.mse.ccd.tictactoe.board.Board;
import de.hse.mse.ccd.tictactoe.board.WinChecker;
import de.hse.mse.ccd.tictactoe.player.Player;
import de.hse.mse.ccd.tictactoe.player.PlayerSymbol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicTacToeGameTest {

  Board board = mock(Board.class);
  WinChecker winChecker = mock(WinChecker.class);
  Player playerA = mock(Player.class);
  Player playerB = mock(Player.class);

  TicTacToeGame ticTacToeGame = new TicTacToeGame(playerA, playerB, board, winChecker);

  @Test
  void play() {
    when(winChecker.hasPlayerWon(any(), any())).thenReturn(true);

    ticTacToeGame.play();

    verify(board).printBoard();
    verify(board, never()).selectCell(eq(playerA.getSymbol()), any());
    verify(board, never()).selectCell(eq(playerB.getSymbol()), any());
  }

  @Test
  void playOneRound() {
    when(winChecker.hasPlayerWon(any(), any())).thenReturn(false, false, true);
    when(board.hasEmptyCells()).thenReturn(false);
    when(playerA.getSymbol()).thenReturn(PlayerSymbol.O);
    when(playerB.getSymbol()).thenReturn(PlayerSymbol.X);

    ticTacToeGame.play();

    verify(board, times(2)).printBoard();
    verify(board).selectCell(eq(playerA.getSymbol()), any());
    verify(board, never()).selectCell(eq(playerB.getSymbol()), any());
  }
}