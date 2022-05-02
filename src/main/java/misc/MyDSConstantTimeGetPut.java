package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MyDSConstantTimeGetPut {

  List<Integer> list;
  Map<Integer, Integer> myHashMap;

  public MyDSConstantTimeGetPut() {
    this.list = new ArrayList<>();
    this.myHashMap = new HashMap<>();
  }

  public void add(int key) {
    if (myHashMap.containsKey(key)) {
      return;
    }
    int idx = list.size();
    list.add(key);
    myHashMap.put(key, idx);
  }

  public void remove(int key) {
    if (!myHashMap.containsKey(key)) {
      return;
    }
    int idx = myHashMap.get(key);
    myHashMap.remove(key);

    int last_idx = list.size() - 1;
    int last_elem = list.get(last_idx);
    Collections.swap(list, idx, last_idx);

    list.remove(last_idx);
    myHashMap.put(last_elem, idx);

  }

  public int search(int skey) {
    if (myHashMap.containsKey(skey)) {
      return myHashMap.get(skey);
    }
    return -1;
  }

  public int getRandom() {
    Random random = new Random();
    int idx = random.nextInt(list.size());

    return list.get(idx);
  }

  public static void main(String[] args) {
    MyDSConstantTimeGetPut myDSConstantTimeGetPut = new MyDSConstantTimeGetPut();
    myDSConstantTimeGetPut.add(10);
    myDSConstantTimeGetPut.add(20);
    myDSConstantTimeGetPut.add(30);
    myDSConstantTimeGetPut.add(40);
    myDSConstantTimeGetPut.add(60);
    System.out.println(myDSConstantTimeGetPut.search(30));
    myDSConstantTimeGetPut.remove(20);
    myDSConstantTimeGetPut.add(50);
    System.out.println(myDSConstantTimeGetPut.search(50));
    System.out.println(myDSConstantTimeGetPut.getRandom());
  }

}
