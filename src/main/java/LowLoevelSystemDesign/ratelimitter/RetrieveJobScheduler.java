package LowLoevelSystemDesign.ratelimitter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RetrieveJobScheduler implements JobScheduler {

  public void startJob() {
    ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
    Runnable task2 = () -> System.out.println("Running Task-2");

    task1();
    ses.schedule(task2, 5, TimeUnit.SECONDS);
    task3();
    ses.shutdown();
  }

  private static void task1() {
    System.out.println("Running Task-1");
  }

  private static void task3() {
    System.out.println("Running Task-2");
  }
}
