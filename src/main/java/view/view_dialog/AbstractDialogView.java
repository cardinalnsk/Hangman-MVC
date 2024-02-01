package view.view_dialog;

import java.util.function.Function;
import java.util.function.Predicate;
import view.Printer;
import view.Reader;

public abstract class AbstractDialogView<T> implements DialogView<T> {

  protected final Printer printer;
  protected final Reader reader;
  protected final String title;
  protected final String errorMessage;
  protected final Predicate<String> predicate;
  protected final Function<String, T> map;


  public AbstractDialogView(Printer printer, Reader reader, String title, String errorMessage,
      Predicate<String> predicate, Function<String, T> map) {
    this.printer = printer;
    this.reader = reader;
    this.title = title;
    this.errorMessage = errorMessage;
    this.predicate = predicate;
    this.map = map;
  }

  protected void showTitle() {
    printer.print(title);
  }

  protected void showError() {
    printer.print(errorMessage);
  }

  @Override
  public T input() {
    while (true) {
      showTitle();
      String key = reader.inputString();
      if (predicate.test(key)) {
        return map.apply(key);
      }
      showError();
    }
  }

}
