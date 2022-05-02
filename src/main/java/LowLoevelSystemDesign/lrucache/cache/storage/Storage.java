package LowLoevelSystemDesign.lrucache.cache.storage;

import LowLoevelSystemDesign.lrucache.cache.exception.NotFoundException;
import LowLoevelSystemDesign.lrucache.cache.exception.StorageFullException;

public interface Storage<Key, Value> {

  void add(Key key, Value value) throws StorageFullException;

  void remove(Key key) throws NotFoundException;

  Value get(Key key) throws NotFoundException;
}
