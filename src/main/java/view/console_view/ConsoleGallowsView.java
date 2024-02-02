package view.console_view;

import model.Gallows;
import view.AbstractView;
import view.Printer;

public class ConsoleGallowsView extends AbstractView<Gallows> {


  public ConsoleGallowsView(Printer printer) {
    super(printer);
  }

  @Override
  public void show(Gallows gallows) {
    String picture = GALLOWS[GALLOWS.length - gallows.getStep() - 1];
    printer.print("\033[31;1m" + picture);
  }


  private static final String[] GALLOWS = {

      """
                  +---+
                  |   |
                  Ø   |
                 /|\\  |
                 / \\  |
                      |
                      |
                =========
                """
      ,

      """
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 /    |
                      |
                      |
                =========
                """
      ,

      """
                  +---+
                  |   |
                  O   |
                 /|\\  |
                      |
                      |
                      |
                =========
                """
      ,

      """
                  +---+
                  |   |
                  O   |
                 /|   |
                      |
                      |
                      |
                =========
                """
      ,

      """
                  +---+
                  |   |
                  O   |
                  |   |
                      |
                      |
                      |
                =========
                """
      ,

      """
                  +---+
                  |   |
                  O   |
                      |
                      |
                      |
                      |
                =========
                """
      ,

      """
                  +---+
                  |   |
                      |
                      |
                      |
                      |
                      |
                =========
                """
      ,

      """
                  
                     
                      
                      
                      
                      
                      
                =========
                """
      ,

      """
                """
  };
}
