package view.console_view;

import model.Word;
import view.AbstractView;
import view.Printer;

public class ConsoleWordView extends AbstractView<Word> {

  private static final char MASK_SYMBOL = '_';

  public ConsoleWordView(Printer printer) {
    super(printer);
  }

  @Override
  public void show(Word word) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.size(); i++) {
      char letter = word.get(i);
      if (word.isOpen(i)) {
        sb.append(letter);
      } else {
        sb.append(MASK_SYMBOL);
      }
    }
    printer.print(sb.toString());
  }
}
