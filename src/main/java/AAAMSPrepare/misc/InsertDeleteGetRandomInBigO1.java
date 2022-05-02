package AAAMSPrepare.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomInBigO1 {

  private List<Integer> list;
  private Map<Integer, Integer> map;

  public InsertDeleteGetRandomInBigO1() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  public void add(int data) {
    if (map.containsKey(data)) {
      return;
    }
    int size = list.size();
    list.add(data);

    map.put(data, size);
  }

  private void remove(int data) {
    int idx = map.get(data);
    if (idx < 1) {
      return;
    }

    map.remove(data);
    int size = list.size();
    int lastElem = list.get(size - 1);
    Collections.swap(list, idx, size - 1);
    list.remove(size - 1);

    map.put(lastElem, idx);
  }

  private int getRandom() {
    Random rand = new Random();
    int idx = rand.nextInt(list.size());
    return list.get(idx);
  }

  private int search(int data) {
    return map.get(data);
  }

  public static void main(String[] args) {
    InsertDeleteGetRandomInBigO1 ds = new InsertDeleteGetRandomInBigO1();
    ds.add(10);
    ds.add(20);
    ds.add(30);
    ds.add(40);
    System.out.println(ds.search(30));
    ds.remove(20);
    ds.add(50);
    System.out.println(ds.search(50));
    System.out.println(ds.getRandom());
  }

}
