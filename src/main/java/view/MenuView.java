package view;

import model.Menu;

public class MenuView extends AbstractView<Menu> {
  public MenuView(Printer printer) {
    super(printer);
  }

  @Override
  public void show(Menu menu) {
    String wall = "#";
    printer.print(wall.repeat(36));
    String title = "%1$s  %2$-30s  %1$s".formatted(wall ,menu.getTitle());
    printer.print(title);
    for (int i = 0; i < menu.size(); i++) {
      String item = "%1$s  %2$d. %3$-27s  %1$s".formatted(wall, i + 1, menu.get(i));
      printer.print(item);
    }
    printer.print(wall.repeat(36));
  }
}
