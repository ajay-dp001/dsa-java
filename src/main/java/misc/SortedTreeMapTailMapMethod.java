package misc;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedTreeMapTailMapMethod {

  public static void main(String[] args) {
    SortedMap<Integer, String> mp = new TreeMap<>();
    mp.put(1, "One");
    mp.put(2, "Two");
    mp.put(3, "Three");
    mp.put(4, "Four");
    mp.put(5, "Five");
    mp.put(6, "Six");
    mp.put(7, "Seven");
    mp.put(8, "Eight");
    System.out.println("Last Key in Map is: " + mp.tailMap(3));
  }

}
