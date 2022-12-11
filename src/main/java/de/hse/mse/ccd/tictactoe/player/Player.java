package de.hse.mse.ccd.tictactoe.player;

import de.hse.mse.ccd.tictactoe.board.Board;
import java.awt.Point;

public abstract class Player {

  protected final PlayerSymbol symbol;

  protected Player(PlayerSymbol symbol) {
    this.symbol = symbol;
  }

  public PlayerSymbol getSymbol() {
    return symbol;
  }

  public abstract Point getNextCellSelection(Board board);

}
