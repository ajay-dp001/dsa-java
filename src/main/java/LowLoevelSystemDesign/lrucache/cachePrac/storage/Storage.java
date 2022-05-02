package LowLoevelSystemDesign.lrucache.cachePrac.storage;

import LowLoevelSystemDesign.lrucache.cache.exception.NotFoundException;
import LowLoevelSystemDesign.lrucache.cache.exception.StorageFullException;

public interface Storage<K, V> {

  void add(K key, V value) throws StorageFullException;

  void remove(K key) throws NotFoundException;

  V get(K key) throws NotFoundException;
}
