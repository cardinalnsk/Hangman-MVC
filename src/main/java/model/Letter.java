package model;

public class Letter {

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

  public char getSymbol() {
    return symbol;
  }

}
