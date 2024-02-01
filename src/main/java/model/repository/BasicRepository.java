package model.repository;

import java.util.Random;

public class BasicRepository implements Repository {

  private final String[] words = {"яблоко", "апельсин", "груша", "банан", "вишня"};

  @Override
  public String get() {
    return words[new Random().nextInt(words.length)];
  }
}
