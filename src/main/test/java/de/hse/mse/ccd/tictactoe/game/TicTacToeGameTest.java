package de.hse.mse.ccd.tictactoe.game;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicTacToeGameTest {

  @Mock
  Board board;
  @Mock
  WinChecker winChecker;
  @Mock
  Player playerA;
  @Mock
  Player playerB;

  @InjectMocks
  TicTacToeGame ticTacToeGame;

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