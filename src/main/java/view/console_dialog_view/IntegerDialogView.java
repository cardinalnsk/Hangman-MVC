package view.console_dialog_view;

import view.AbstractDialogView;
import view.Printer;
import view.Reader;

public class IntegerDialogView extends AbstractDialogView<Integer> {


  public IntegerDialogView(Printer printer, Reader reader, String title, String errorMessage,
      int min, int max) {
    super(printer,
        reader,
        title,
        errorMessage,
        s -> isInteger(s) && inRange(min, max, Integer.parseInt(s)),
        Integer::parseInt
    );
  }


  private static boolean inRange(int min, int max, int value) {
    return value >= min && value <= max;
  }

  private static boolean isInteger(String key) {
    try {
      Integer.parseInt(key);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
