package threads.pracvm.evenodd;


public class EvenOddMain {

  public static void main(String[] args) {
    final State state = new State(PrintType.ODD);
    final EvenOddRunnable myRun1 = new EvenOddRunnable(1, state, PrintType.ODD, 50);
    final EvenOddRunnable myRun2 = new EvenOddRunnable(2, state, PrintType.EVEN, 50);

    Thread t1 = new Thread(myRun1);
    Thread t2 = new Thread(myRun2);

    t1.start();
    t2.start();
  }

}
