package queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNo {

  private static void generateBinary(int num) {
    Queue<String> queue = new LinkedList<>();
    queue.add("1");

    while (num-- > 0) {
      String str1= queue.remove();
      System.out.println(str1);

      String str2= str1;
      queue.add(str1+"0");
      queue.add(str2+"1");
    }
  }

  public static void main(String[] args) {
    int num = 10;
    generateBinary(num);
  }
}
