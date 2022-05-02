package misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

  public static void main(String[] args) {
    Comparator<Integer> cmp = new Comparator<Integer>() {
      @Override
      public int compare(Integer num1, Integer num2) {
        return num1 > num2 ? 1 : -1;
      }
    };
    Queue<Integer> pQue = new PriorityQueue<>();
    pQue.add(10);
    pQue.add(1);
    pQue.add(23);
    pQue.add(44);
    pQue.add(44);
    pQue.add(51);
    System.out.println(pQue.peek());
    System.out.println(pQue.poll());
    System.out.println(pQue.peek());
    while (!pQue.isEmpty()) {
      System.out.print(pQue.poll() + " ");
    }
  }

}
