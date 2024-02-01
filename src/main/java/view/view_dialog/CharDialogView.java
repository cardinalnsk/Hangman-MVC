package view.view_dialog;

import view.Printer;
import view.Reader;

public class CharDialogView extends AbstractDialogView<Character> {


  public CharDialogView(Printer printer, Reader reader, String title, String errorMessage) {
    super(printer,
        reader,
        title,
        errorMessage,
        s -> s.length() == 1 && Character.isAlphabetic(s.charAt(0)),
        s -> s.charAt(0));
  }

}
