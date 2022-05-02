package collection.prac;

public class CustomHashMap<K, V> {

  private int DEFAULT_CAP = 16;
  private int initialCapacity;
  private Entry<K, V>[] entryTable;

  private static class Entry<K, V> {

    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }

    public K getKey() {
      return this.key;
    }

    public void setKey(K key) {
      this.key = key;
    }

    public V getValue() {
      return this.value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public Entry<K, V> getNext() {
      return this.next;
    }

    public void setNext(Entry<K, V> entry) {
      this.next = entry;
    }
  }

  public CustomHashMap() {
    this.initialCapacity = DEFAULT_CAP;
    this.entryTable = new Entry[initialCapacity];
  }

  public CustomHashMap(final int capacity) {
    this.initialCapacity = capacity;
    this.entryTable = new Entry[initialCapacity];
  }

  private int getIndex(final K key) {
    if (key == null) {
      return 0;
    }
    return Math.abs(key.hashCode() % initialCapacity);
  }

  //O(1) worstCase On
  public void put(K key, V value) {
    int index = getIndex(key);
    Entry<K, V> newEntry = new Entry<>(key, value);
    if (entryTable[index] == null) {
      entryTable[index] = newEntry;
    } else {
      Entry<K, V> prevEntry = null;
      Entry<K, V> currEntry = entryTable[index];
      while (currEntry != null) {
        if (currEntry.getKey().equals(key)) {
          currEntry.setValue(value);
          break;
        }
        prevEntry = currEntry;
        currEntry = currEntry.next;
      }
      if (prevEntry != null) {
        prevEntry.setNext(newEntry);
      }
    }
  }

  public V get(K key) {
    V value = null;
    int index = getIndex(key);
    Entry<K, V> entry = entryTable[index];
    while (entry != null) {
      if (entry.getKey().equals(key)) {
        value = entry.getValue();
        break;
      }
      entry = entry.next;
    }
    return value;
  }

  public void remove(K key) {
    int index = getIndex(key);
    Entry<K, V> prevEntry = null;
    Entry<K, V> currEntry = entryTable[index];
    while (currEntry != null) {
      if (currEntry.getKey().equals(key)) {
        if (prevEntry == null) {
          currEntry = currEntry.getNext();
          entryTable[index] = currEntry;
        } else {
          prevEntry.setNext(currEntry.getNext());
        }
        return;
      }
      prevEntry = currEntry;
      currEntry = currEntry.next;
    }
  }

  public void removeElement(K key) {
    int index = getIndex(key);
    Entry<K, V> prevEntry = null;
    Entry<K, V> currEntry = entryTable[index];
    while (currEntry != null) {
      if (currEntry.getKey().equals(key)) {
        if (prevEntry == null) {
          currEntry = currEntry.next;
          entryTable[index] = currEntry;
        } else {
          prevEntry.setNext(currEntry.getNext());
        }
        return;
      }
      prevEntry = currEntry;
      currEntry = currEntry.next;
    }
  }

}
