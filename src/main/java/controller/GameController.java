package controller;

import model.Gallows;
import model.Menu;
import model.SymbolStorage;
import model.Word;
import model.repository.Repository;
import view.console_view.ConsoleMenuView;
import view.View;
import view.console_dialog_view.IntegerDialogView;
import view.console_view.ConsoleGallowsView;
import view.Printer;
import view.Reader;
import view.console_dialog_view.CharDialogView;
import view.console_dialog_view.DialogView;
import view.console_view.ConsoleSymbolStorageView;
import view.console_view.ConsoleWordView;

public class GameController {

  private static final String ANSI_CLEAR = "\033[H\033[2J";
  private static final String ANSI_RED = "\033[31;1m";
  private static final String ANSI_GREEN = "\033[32;1m";
  private static final String WIN_MESSAGE = "Ты красавчик, %sпобедил!";
  private static final String LOSE_MESSAGE = "Ты не красавчик, %sпроиграл";
  private static final String INVALID_INPUT = "%sНекорректный ввод";
  private static final String LETTER_ALREADY_EXIST_IN_STORAGE = "Буква уже была введена ранее";

  private final Printer printer;
  private final Repository repository;
  private final View<SymbolStorage> symbolStorageView;
  private final View<Word> wordView;
  private final View<Gallows> gallowsView;
  private final Menu menu;
  private final View<Menu> menuView;

  private final DialogView<Character> characterDialogView;
  private final DialogView<Integer> integerDialogView;

  private Word word;
  private SymbolStorage symbolStorage;
  private Gallows gallows;

  public GameController(Printer printer, Reader reader, Repository repository) {
    this.printer = printer;
    this.repository = repository;
    this.menu = new Menu("Welcome to Hangman!");
    menu.addItem("Start new game");
    menu.addItem("Exit");
    this.symbolStorageView = new ConsoleSymbolStorageView(printer);
    this.wordView = new ConsoleWordView(printer);
    this.gallowsView = new ConsoleGallowsView(printer);
    this.characterDialogView = new CharDialogView(printer, reader, "Введите одну букву",
        INVALID_INPUT.formatted(ANSI_RED));
    this.integerDialogView = new IntegerDialogView(printer, reader, "Введите пункт меню",
        INVALID_INPUT.formatted(ANSI_RED), 1, menu.size());
    this.menuView = new ConsoleMenuView(printer);
  }

  private void processDataForGame() {
    this.word = new Word(repository.get());
    this.gallows = new Gallows();
    this.symbolStorage = new SymbolStorage();
  }


  public void startGame() {
    while (true) {
      menuView.show(menu);
      Integer menuPoint = integerDialogView.input();
      if (menuPoint == 2) {
        return;
      }
      gameProcess();
    }
  }

  private void gameProcess() {
    processDataForGame();
    while (true) {
      showInfo();
      Character input = characterDialogView.input();
      if (symbolStorage.contains(input)) {
        printer.print(LETTER_ALREADY_EXIST_IN_STORAGE);
        continue;
      }
      symbolStorage.add(input);
      if (word.contains(input)) {
        word.open(input);
      } else {
        gallows.incStep();
      }
      if (isWin() || isLose()) {
        break;
      }
    }
    showResult();
  }

  private void showResult() {
    showInfo();
    if (isWin()) {
      printer.print(WIN_MESSAGE.formatted(ANSI_GREEN));
    } else {
      printer.print(LOSE_MESSAGE.formatted(ANSI_RED));
    }
    wordView.show(word.openWord());
  }

  private void showInfo() {
    printer.print(ANSI_CLEAR);
    gallowsView.show(gallows);
    wordView.show(word);
    symbolStorageView.show(symbolStorage);
  }

  private boolean isWin() {
    return word.isAllVisible();
  }

  private boolean isLose() {
    return gallows.isMaxStep();
  }
}
