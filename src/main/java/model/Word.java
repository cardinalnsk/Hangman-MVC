package model;

import lombok.Getter;

@Getter
public class Word {

  private final Letter[] letters;

  public Word(String word) {
    this.letters = new Letter[word.length()];
    for (int i = 0; i < word.length(); i++) {
      letters[i] = new Letter(word.charAt(i));
    }
  }

  public char get(int index) {
    return letters[index].getSymbol();
  }

  public int size() {
    return letters.length;
  }

  public void open(char symbol) {
    if (!contains(symbol)) {
      throw new IllegalArgumentException("Symbol not present: " + symbol);
    }

    for (Letter letter : letters) {
      if (letter.getSymbol() == symbol) {
        letter.open();
      }
    }
  }

  public boolean isOpen(int index) {
    return letters[index].isOpen();
  }

  public boolean contains(char symbol) {
    for (Letter letter : letters) {
      if (letter.getSymbol() == symbol) {
        return true;
      }
    }
    return false;
  }

  public boolean isAllVisible() {
    for (Letter letter : letters) {
      if (!letter.isOpen()) {
        return false;
      }
    }
    return true;
  }
}
