package view.console_view;

import java.util.List;
import model.SymbolStorage;
import view.AbstractView;
import view.Printer;

public class ConsoleSymbolStorageView extends AbstractView<SymbolStorage> {


  public ConsoleSymbolStorageView(Printer printer) {
    super(printer);
  }

  @Override
  public void show(SymbolStorage symbolStorage) {
    StringBuilder sb = new StringBuilder("[");
    List<Character> list = symbolStorage.toList();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if (i < list.size() - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    printer.print(sb.toString());
  }
}
