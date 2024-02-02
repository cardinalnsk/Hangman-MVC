package view.console_view;

import model.Menu;
import view.AbstractView;
import view.Printer;

public class ConsoleMenuView extends AbstractView<Menu> {
  public ConsoleMenuView(Printer printer) {
    super(printer);
  }

  @Override
  public void show(Menu menu) {
    String wall = "#";
    printer.print(wall.repeat(25));
    String title = "%1$s  %2$-19s  %1$s".formatted(wall ,menu.getTitle());
    printer.print(title);
    for (int i = 0; i < menu.size(); i++) {
      String item = "%1$s  %2$d. %3$-16s  %1$s".formatted(wall, i + 1, menu.get(i));
      printer.print(item);
    }
    printer.print(wall.repeat(25));
  }
}
