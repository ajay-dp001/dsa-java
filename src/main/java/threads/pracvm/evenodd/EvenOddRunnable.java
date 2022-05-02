package threads.pracvm.evenodd;

import lombok.SneakyThrows;

public class EvenOddRunnable implements Runnable {

  private final static int STEP = 2;

  private final State state;
  private int currentValue;
  private int maxValue;
  private PrintType currPrintType;

  public EvenOddRunnable(int startValue, State state, PrintType printType, int maxValue) {
    this.state = state;
    this.currentValue = startValue;
    this.maxValue = maxValue;
    this.currPrintType = printType;
  }

  @SneakyThrows
  @Override
  public void run() {
    while (currentValue <= maxValue) {
      synchronized (state) {
        while (currPrintType != state.getNextToPrint()) {
          state.wait();
        }
        System.out.println(
            Thread.currentThread().getName() + " " + currPrintType.toString() + " :" + currentValue);
        currentValue += STEP;
        state.setNextToPrint(state.nextPrintType(currPrintType));
        state.notifyAll();
      }
    }
  }
}
