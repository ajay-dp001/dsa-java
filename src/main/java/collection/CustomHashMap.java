package collection;

public class CustomHashMap<K, V> {

  private int defaultCapacity = 16;
  private Entry<K, V>[] table;

  public static class Entry<K, V> {

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

  public CustomHashMap() {
    table = new Entry[defaultCapacity];
  }

  public CustomHashMap(int capacity) {
    this.defaultCapacity = capacity;
    table = new Entry[defaultCapacity];
  }

  public static void main(String[] args) {
    CustomHashMap<String, Integer> cmap = new CustomHashMap<>();
    cmap.put("A", 1);
    cmap.put("B", 2);
    cmap.put("B", 4);
    cmap.display();
    cmap.remove("B");
    cmap.put("C", 3);
    cmap.display();
    cmap.put("D", 4);
    cmap.put("E", 5);
    cmap.put("F", 6);
    cmap.remove("E");
    cmap.put("G", 7);
    cmap.display();
  }

  private int index(K key) {
    if (key == null) {
      return 0;
    }
    return Math.abs(key.hashCode() % defaultCapacity);
  }

  public void put(K key, V value) {
    int index = index(key);
    Entry<K, V> newEntry = new Entry<>(key, value);
    if (table[index] == null) {
      table[index] = newEntry;
    } else {
      Entry<K, V> prevNode = null;
      Entry<K, V> currNode = table[index];
      while (currNode != null) {
        if (currNode.getKey().equals(key)) {
          currNode.setValue(value);
          break;
        }
        prevNode = currNode;
        currNode = currNode.next;
      }
      if (prevNode != null) {
        prevNode.setNext(newEntry);
      }
    }
  }

  public V get(K key) {
    V value = null;
    int index = index(key);
    Entry<K, V> entry = table[index];
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
    int index = index(key);
    Entry<K, V> prevNode = null;
    Entry<K, V> currNode = table[index];
    while (currNode != null) {
      if (currNode.getKey().equals(key)) {
        if (prevNode == null) {
          currNode = currNode.getNext();
          table[index] = currNode;
        } else {
          prevNode.setNext(currNode.getNext());
        }
        return;
      }
      prevNode = currNode;
      currNode = currNode.next;
    }
  }

  public void display() {
    for (int i = 0; i < defaultCapacity; i++) {
      if (table[i] != null) {
        Entry<K, V> currNode = table[i];
        while (currNode != null) {
          System.out.println(
              String.format("Key is %s and Value is %s", currNode.getKey(), currNode.getValue()));
          currNode = currNode.next;
        }
      }
    }
  }
}
