package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Test {

  public static void main(String[] args) {
    ConcurrentLinkedDeque<Integer> cld = new ConcurrentLinkedDeque<>();
    cld.addFirst(12);
    cld.addFirst(70);
    cld.addFirst(1009);
    cld.addFirst(475);

    System.out.println("ConcurrentLinkedDeque: " + cld);
    System.out.println("The Last element is: " + cld.getLast());
    System.out.println("First Element is: " + cld.peekFirst());
    cld.removeLast();
    cld.add(122);
    cld.add(110);
    System.out.println("ConcurrentLinkedDeque: " + cld);

    cld.addFirst(55);
    System.out.println("ConcurrentLinkedDeque: " + cld);

    char[] a = new char[256];
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    char ch = 'A';
    Map<Integer, List<Character>> map = new HashMap<>();
    map.put(1, new ArrayList<>(10));
    List<Character> list = map.get(1);
    list.add(ch);
    System.out.println(map);

    System.out.println(isPalindrome(-121));
  }

  public static boolean isPalindrome(int x) {
    int input = Math.abs(x), num = 0;
    while (input != 0) {
      int n = input % 10;
      num = num * 10 + n;
      input = input / 10;
    }
    if (num == Math.abs(x)) {
      return true;
    } else {
      return false;
    }
  }

}
