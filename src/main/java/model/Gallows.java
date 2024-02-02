package model;

public class Gallows {

  private static final int MAX_STEP = 8;
  private int step;

  public Gallows(int step) {
    this.step = step;
  }

  public Gallows() {
    this(0);
  }

  public void incStep() {
    step++;
  }

  public boolean isMaxStep() {
    return step == MAX_STEP;
  }

  public int getStep() {
    return step;
  }
}
