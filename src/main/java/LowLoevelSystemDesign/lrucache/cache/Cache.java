package LowLoevelSystemDesign.lrucache.cache;

import LowLoevelSystemDesign.lrucache.cache.exception.NotFoundException;
import LowLoevelSystemDesign.lrucache.cache.exception.StorageFullException;
import LowLoevelSystemDesign.lrucache.cache.policies.EvictionPolicy;
import LowLoevelSystemDesign.lrucache.cache.policies.LRUEvictionPolicy;
import LowLoevelSystemDesign.lrucache.cache.storage.KeyValueBasedStorage;
import LowLoevelSystemDesign.lrucache.cache.storage.Storage;

public final class Cache<Key, Value> {

  private static final int DEFAUT_CAP = 10;
  private final EvictionPolicy<Key> evictionPolicy;
  private final Storage<Key, Value> storage;
  private static volatile Cache<Integer, Integer> singleCacheInstance;

  private Cache(int cap) {
    this.evictionPolicy = new LRUEvictionPolicy<>();
    this.storage = new KeyValueBasedStorage<>(cap);
  }

  public static Cache<Integer, Integer> getInstance() {
    if (singleCacheInstance != null) {
      return singleCacheInstance;
    }
    synchronized (Cache.class) {
      if (singleCacheInstance == null) {
        singleCacheInstance = new Cache<>(DEFAUT_CAP);
      }
    }
    return singleCacheInstance;
  }

  public void put(Key key, Value value) {
    try {
      this.storage.add(key, value);
      this.evictionPolicy.keyAccessed(key);
    } catch (StorageFullException sfe) {
      System.out.println("Storage Full Exception, Will try to Evict");
      Key keyToRemove = evictionPolicy.evictKey();
      if (keyToRemove == null) {
        throw new RuntimeException("Storage Full and No key to remove");
      }
      this.storage.remove(key);
      System.out.println("Space Created by Evicting Key :" + keyToRemove);
      put(key, value);
    }
  }

  public Value get(Key key) {
    try {
      Value val = this.storage.get(key);
      this.evictionPolicy.keyAccessed(key);
      return val;
    } catch (NotFoundException nfe) {
      System.out.println("Tried to access non existing key");
      return null;
    }
  }
}
