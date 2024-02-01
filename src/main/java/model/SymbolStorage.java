package model;

import java.util.ArrayList;
import java.util.List;


public class SymbolStorage {

  private final List<Character> symbols;

  public SymbolStorage() {
    this.symbols = new ArrayList<>();
  }

  public boolean contains(Character letter) {
    return symbols.contains(letter);
  }

  public void add(Character letter) {
    if (contains(letter)) {
      throw new IllegalArgumentException("Letter contains in storage: " + letter);
    }
    symbols.add(letter);
  }


  public List<Character> toList() {
    return new ArrayList<>(symbols);
  }
}
