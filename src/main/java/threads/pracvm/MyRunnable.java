package threads.pracvm;

public class MyRunnable implements Runnable {

  private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

  @Override
  public void run() {
    threadLocal.set((int) (Math.random() * 100D));
    try {
      Thread.sleep(200);
    } catch (InterruptedException ie) {
      System.out.println("Exception :" + ie.getCause());
    }
    System.out.println("ThreadLocal Details from " + Thread.currentThread().getName() + " Value :"
        + threadLocal.get());
  }

  public static void main(String[] args) {
    MyRunnable myRun1 = new MyRunnable();
    Thread t1 = new Thread(myRun1);
    Thread t2 = new Thread(myRun1);

    t1.start();
    t2.start();
  }
}
