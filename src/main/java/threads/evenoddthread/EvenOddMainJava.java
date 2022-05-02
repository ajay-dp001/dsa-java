package threads.evenoddthread;

public class EvenOddMainJava {

  public static void main(String[] args) {
    final State state = new State(PrinterType.ODD);
    final MyRunnable myRunnable1 = new MyRunnable(1, 2, state, PrinterType.ODD, PrinterType.EVEN, 50);
    final MyRunnable myRunnable2 = new MyRunnable(2, 2, state, PrinterType.EVEN, PrinterType.ODD, 50);

    final Thread oddThread = new Thread(myRunnable1);
    final Thread evenThread = new Thread(myRunnable2);

    oddThread.start();
    evenThread.start();
  }
}
