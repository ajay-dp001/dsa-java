package LowLoevelSystemDesign.lrucache.cachePrac.storage;

import LowLoevelSystemDesign.lrucache.cache.exception.NotFoundException;
import LowLoevelSystemDesign.lrucache.cache.exception.StorageFullException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyValueBasedStorage<K, V> implements Storage<K, V> {

  private int capacity;
  private Map<K, V> storage;

  public KeyValueBasedStorage(int capacity) {
    this.capacity = capacity;
    storage = new ConcurrentHashMap<>();
  }

  @Override
  public void add(Object key, Object value) throws StorageFullException {

  }

  @Override
  public void remove(Object key) throws NotFoundException {

  }

  @Override
  public Object get(Object key) throws NotFoundException {
    return null;
  }
}
