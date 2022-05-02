package collection.prac;

public class CustomHashMapPrac<K, V> {

  private int capacity;
  private Entry<K, V>[] buckets;

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

    public void setNext(Entry<K, V> next) {
      this.next = next;
    }
  }

  private CustomHashMapPrac(int capacity) {
    this.capacity = capacity;
    this.buckets = new Entry[capacity];
  }

  private int getIndex(K key) {
    if (key == null) {
      return 0;
    }
    return Math.abs(key.hashCode() % capacity);
  }

  //Best case is O(1) Worst case is O(n)
  public void put(K key, V value) {
    int index = getIndex(key);
    Entry<K, V> newEntry = new Entry<>(key, value);
    if (buckets[index] == null) {
      buckets[index] = newEntry;
    } else {
      Entry<K, V> prev = null;
      Entry<K, V> currEntry = buckets[index];
      while (currEntry != null) {
        if (currEntry.getKey().equals(key)) {
          currEntry.setValue(value);
          break;
        }
        prev = currEntry;
        currEntry = currEntry.next;
      }
      if (prev != null) {
        prev.setNext(newEntry);
      }
    }
  }

  //Best case is O(1) Worst case is O(n)
  public V get(K key) {
    V value = null;
    int index = getIndex(key);
    Entry<K, V> entry = buckets[index];
    while (entry != null) {
      if (entry.key.equals(key)) {
        value = entry.getValue();
        break;
      }
      entry = entry.next;
    }
    return value;
  }

  //Best case is O(1) Worst case is O(n)
  public void remove(K key) {
    int index = getIndex(key);
    Entry<K, V> prevEntry = null;
    Entry<K, V> currEntry = buckets[index];
    while (currEntry != null) {
      if (currEntry.key.equals(key)) {
        if (prevEntry == null) {
          currEntry = currEntry.getNext();
          buckets[index] = currEntry;
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
    CustomHashMapPrac<Integer, Integer> cmap = new CustomHashMapPrac<>(10);
    cmap.put(10, 100);
  }
}
