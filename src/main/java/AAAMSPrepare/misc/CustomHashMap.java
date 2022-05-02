package AAAMSPrepare.misc;

public class CustomHashMap<K, V> {

  private int capacity = 10;
  private Entry<K, V>[] entryTable;

  private static class Entry<K, V> {

    private K key;
    private V value;
    private Entry<K, V> next;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
      this.next = null;
    }

    public K getKey() {
      return key;
    }

    public void setKey(K key) {
      this.key = key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public Entry<K, V> getNext() {
      return next;
    }

    public void setNext(Entry<K, V> next) {
      this.next = next;
    }
  }

  public CustomHashMap(int capacity) {
    this.capacity = capacity;
    this.entryTable = new Entry[capacity];
  }

  private int getIndex(K key) {
    if (key == null) {
      return 0;
    }
    return Math.abs(key.hashCode() % capacity);
  }

  private void put(K key, V value) {
    int index = getIndex(key);
    Entry<K, V> newEntry = new Entry<>(key, value);
    if (entryTable[index] == null) {
      entryTable[index] = newEntry;
    } else {
      Entry<K, V> prev = null;
      Entry<K, V> currEntry = entryTable[index];
      while (currEntry != null) {
        if (currEntry.getKey().equals(key)) {
          currEntry.setValue(value);
          break;
        }
        prev = currEntry;
        currEntry = currEntry.next;
      }
      if (prev != null) {
        prev.setNext(currEntry);
      }
    }
  }

  private V get(K key) {
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

  private void remove(K key) {
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

  public static void main(String[] args) {
    CustomHashMap<Integer, Integer> map = new CustomHashMap<>(10);
    map.put(10, 100);
  }
}
