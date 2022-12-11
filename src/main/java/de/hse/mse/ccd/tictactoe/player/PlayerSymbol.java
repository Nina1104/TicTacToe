package de.hse.mse.ccd.tictactoe.player;

public enum PlayerSymbol {
  X("X"),
  O("O");

  public final String label;

  PlayerSymbol(String label) {
    this.label = label;
  }
}
