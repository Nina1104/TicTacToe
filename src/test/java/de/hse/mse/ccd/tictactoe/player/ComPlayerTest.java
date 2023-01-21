package de.hse.mse.ccd.tictactoe.player;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hse.mse.ccd.tictactoe.board.Board;
import java.awt.Point;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ComPlayerTest {

  Random random = mock(Random.class);
  ComPlayer comPlayer = new ComPlayer(PlayerSymbol.X, random);

  @Test
  void getNextCellSelection() {
    Board board = mock(Board.class);
    int boardSize = 3;
    when(board.getSize()).thenReturn(boardSize);
    int x = 1;
    int y = 2;
    when(random.nextInt(boardSize)).thenReturn(x, y);
    when(board.isCellSelectable(any())).thenReturn(true);

    Point nextCellSelection = comPlayer.getNextCellSelection(board);

    verify(random, times(2)).nextInt(boardSize);
    assertEquals(x, nextCellSelection.x);
    assertEquals(y, nextCellSelection.y);
  }

  @Test
  void getNextCellSelectionTryAgainIfCellNotSelectable() {
    Board board = mock(Board.class);
    int boardSize = 3;
    when(board.getSize()).thenReturn(boardSize);
    int x = 1;
    int y = 2;
    when(random.nextInt(boardSize)).thenReturn(1, 1, x, y);
    when(board.isCellSelectable(any())).thenReturn(false, true);

    Point nextCellSelection = comPlayer.getNextCellSelection(board);

    verify(random, times(4)).nextInt(boardSize);
    assertEquals(y, nextCellSelection.x);
    assertEquals(x, nextCellSelection.y);
  }
}