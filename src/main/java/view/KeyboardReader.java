package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class KeyboardReader implements Reader {

  private final BufferedReader bf;

  public KeyboardReader() {
    this.bf = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
  }

  @Override
  public int inputNumber() {
    try {
      return Integer.parseInt(bf.readLine().trim());
    } catch (IOException | NumberFormatException e) {
      throw new NumberFormatException("Invalid input");
    }
  }

  @Override
  public String inputString() throws IllegalArgumentException {
    try {
      return bf.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
