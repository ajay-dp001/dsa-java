package LowLoevelSystemDesign.lrucache;

import LowLoevelSystemDesign.lrucache.cache.Cache;

public class CacheMain {

  public static void main(String[] args) {
    Cache<Integer, Integer> cache = Cache.getInstance();
    cache.put(10, 100);
  }

}
