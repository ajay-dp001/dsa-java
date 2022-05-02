package AAAMSPrepare.misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private static class Node {

    int key, value;
    Node prev, next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = this.next = null;
    }
  }

  private static final int DEFAULT_CAPACITY = 5;
  private int capacity;
  private Node head, tail;
  private Map<Integer, Node> cache = null;

  public LRUCache() {
    this(DEFAULT_CAPACITY);
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
  }

  private void deleteNode(Node node) {
    if (node.prev != null) {
      node.prev.next = node.next;
    } else {
      head = node.next;
    }

    if (node.next != null) {
      node.next.prev = node.prev;
    } else {
      tail = node.prev;
    }
  }

  private void setHead(Node node) {
    node.next = head;
    node.prev = null;

    if (head != null) {
      head.prev = node;
    }
    head = node;
    if (tail == null) {
      tail = head;
    }
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node tempNode = cache.get(key);
      deleteNode(tempNode);
      setHead(tempNode);
      return tempNode.key;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      Node tempNode = cache.get(key);
      tempNode.value = value;
      deleteNode(tempNode);
      setHead(tempNode);
    } else {
      Node newNode = new Node(key, value);
      if (cache.size() > capacity) {
        cache.remove(tail.key);
        deleteNode(tail);
        setHead(newNode);
      } else {
        setHead(newNode);
      }
      cache.put(key, newNode);
    }
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache();
    lruCache.put(1, 100);
    lruCache.put(2, 99);
    lruCache.put(3, 98);
    lruCache.put(4, 97);
    lruCache.put(5, 96);
    lruCache.put(6, 95);
    lruCache.put(7, 94);
  }

}
