package view;

public class ConsolePrinter implements Printer {

  private static final String ANSI_WHITE = "\033[39;49m";

  @Override
  public void print(String msg) {
    System.out.println(ANSI_WHITE + msg);
  }

}
