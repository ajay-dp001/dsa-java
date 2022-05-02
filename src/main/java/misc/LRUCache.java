package misc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  static class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      prev = next = null;
    }
  }

  Node head;
  Node tail;
  Map<Integer, Node> map = null;
  int cap = 0;

  public LRUCache(int capacity) {
    this.cap = capacity;
    this.map = new HashMap<>(capacity);
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      deleteNode(node);
      setHead(node);
      return node.value;
    }
    return -1;
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

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node old = map.get(key);
      old.value = value;

      deleteNode(old);
      setHead(old);
    } else {
      Node newNode = new Node(key, value);
      if (map.size() >= cap) {
        map.remove(tail.key);
        deleteNode(tail);
        setHead(newNode);
      } else {
        setHead(newNode);
      }
      map.put(key, newNode);
    }
  }

  public static void main(String[] args) {
    LRUCache lrucache = new LRUCache(4);
    lrucache.put(1, 100);
    lrucache.put(10, 99);
    lrucache.put(15, 98);
    lrucache.put(10, 97);
    lrucache.put(12, 96);
    lrucache.put(18, 95);
    lrucache.put(1, 94);
    System.out.println(lrucache.get(1));
    System.out.println(lrucache.get(10));
    System.out.println(lrucache.get(15));
  }
}
