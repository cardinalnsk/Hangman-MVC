package model;

import lombok.Getter;

public class Letter {
  @Getter
  private final char symbol;
  private boolean isOpen;

  public Letter(char symbol) {
    this.symbol = symbol;
    this.isOpen = false;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void open() {
    this.isOpen = true;
  }

}
