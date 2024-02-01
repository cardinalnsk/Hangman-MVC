package model.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FileRepository implements Repository {

  private final List<String> words;

  public FileRepository() {
    this.words = new ArrayList<>();
    readWordsFromResourceFile();
  }

  private void readWordsFromResourceFile() {
    try (
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("words.txt");
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(Objects.requireNonNull(inputStream)))
    ) {
      while (reader.readLine() != null) {
        words.add(reader.readLine().toLowerCase());
      }
    } catch (IOException e) {
      throw new RuntimeException("IO exception: {}", e);
    }
  }


  @Override
  public String get() {
    return words.get(new Random().nextInt(words.size()));
  }
}
