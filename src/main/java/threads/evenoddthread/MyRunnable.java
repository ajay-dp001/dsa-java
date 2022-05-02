package threads.evenoddthread;

import lombok.SneakyThrows;

public class MyRunnable implements Runnable {

  private final int step;
  public final State state;
  private int currentValue;
  private final PrinterType currPrintType;
  private final PrinterType nextPrintType;
  private final int max;


  public MyRunnable(final int startVal, final int step, final State state, final PrinterType currPrintType,
      final PrinterType nextPrintType, final int num) {
    this.currentValue = startVal;
    this.step = step;
    this.state = state;
    this.currPrintType = currPrintType;
    this.nextPrintType = nextPrintType;
    this.max = num;
  }

  @SneakyThrows
  @Override
  public void run() {
    while (currentValue <= max) {
      synchronized (state) {
        while (this.currPrintType != state.getNextToPrint()) {
          state.wait();
        }
        System.out.println(
            "Thread Name: " + Thread.currentThread().getName() + " " + currPrintType.toString() + " :"
                + currentValue);
        currentValue += step;
        state.setNextToPrint(this.nextPrintType);
        state.notifyAll();
      }
    }
  }
}
