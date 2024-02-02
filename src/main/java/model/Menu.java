package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

  private final String title;

  private final List<String> items;

  public Menu(String title) {
    this.title = title;
    this.items = new ArrayList<>();
  }

  public void addItem(String item) {
    items.add(item);
  }

  public String get(int index) {
    return items.get(index);
  }

  public int size() {
    return items.size();
  }

  public String getTitle() {
    return title;
  }

}
