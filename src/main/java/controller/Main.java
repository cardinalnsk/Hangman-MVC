package controller;

import model.repository.FileRepository;
import model.repository.Repository;
import view.ConsolePrinter;
import view.KeyboardReader;
import view.Printer;
import view.Reader;

public class Main {

  public static void main(String[] args) {
    Printer printer = new ConsolePrinter();
    Reader reader = new KeyboardReader();
    Repository repository = new FileRepository();
    GameController gameController = new GameController(printer, reader, repository);
    gameController.startGame();
  }

}
