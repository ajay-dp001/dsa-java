package LowLoevelSystemDesign.lrucache.cache.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import LowLoevelSystemDesign.lrucache.cache.exception.NotFoundException;
import LowLoevelSystemDesign.lrucache.cache.exception.StorageFullException;

public class KeyValueBasedStorage<Key, Value> implements Storage<Key, Value> {

  private final int capacity;
  protected final Map<Key, Value> storage;

  public KeyValueBasedStorage(int capacity) {
    this.capacity = capacity;
    this.storage = new ConcurrentHashMap<>();
  }

  @Override
  public void add(Key key, Value value) throws StorageFullException {
    if (isStorageFull()) {
      throw new StorageFullException("Storage Capicity is Full");
    }
    storage.put(key, value);
  }

  @Override
  public void remove(Key key) throws NotFoundException {
    if (!storage.containsKey(key)) {
      throw new NotFoundException("Key :" + key + " doesn't exist in cache.");
    }
    storage.remove(key);
  }

  @Override
  public Value get(Key key) throws NotFoundException {
    if (!storage.containsKey(key)) {
      throw new NotFoundException("Key :" + key + " doesn't exist in cache.");
    }
    return storage.get(key);
  }

  private boolean isStorageFull() {
    return storage.size() == capacity;
  }
}
