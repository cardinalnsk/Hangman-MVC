package controller;

import model.Gallows;
import model.Menu;
import model.SymbolStorage;
import model.Word;
import model.repository.Repository;
import view.MenuView;
import view.View;
import view.view_dialog.IntegerDialogView;
import view.console_view.ConsoleGallowsView;
import view.Printer;
import view.Reader;
import view.view_dialog.CharDialogView;
import view.view_dialog.DialogView;
import view.console_view.ConsoleSymbolStorageView;
import view.console_view.ConsoleWordView;

public class GameController {

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
    this.characterDialogView = new CharDialogView(printer, reader, "Введите одну букву", "Некорректный ввод");
    this.integerDialogView = new IntegerDialogView(printer, reader, "Введите пункт меню", "Некорректный ввод", 1, menu.size());
    this.menuView = new MenuView(printer);
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
      game();
    }
  }

  private void game() {
    processDataForGame();
    while (true) {
      showInfo();
      Character input = characterDialogView.input();
      if (symbolStorage.contains(input)) {
        printer.print("Буква уже была введена ранее");
        continue;
      }
      symbolStorage.add(input);
      if (word.contains(input)) {
        word.open(input);
      } else {
        gallows.incStep();
      }
      if (isWin()) {
        showInfo();
        printer.print("Ты красавчик, победил!");
        break;
      }
      if (isLose()) {
        showInfo();
        printer.print("Ты не красавчик, проиграл!");
        break;
      }
    }
  }

  private void showInfo() {
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
