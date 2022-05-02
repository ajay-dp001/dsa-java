package collection.prac;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

  public Node head, tail;
  private final int capacity;
  private Map<Integer, Node> map = null;

  private static class Node {

    int key, value;
    Node prev, next;

    public Node(int key, int val) {
      this.key = key;
      this.value = val;
      prev = next = null;
    }
  }

  public LRUCache(int capacity) {
    head = tail = null;
    this.capacity = capacity;
    map = new ConcurrentHashMap<>(capacity);
  }

  private void deleteNode(Node node) {
    if (node.prev != node) {
      node.prev.next = node.next;
    } else {
      head = node.next;
    }

    if (node.next != node) {
      node.next.prev = node.prev;
    } else {
      tail = node.prev;
    }
  }

  private void deleteNodePrac(Node node) {
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
      Node oldNode = map.get(key);
      oldNode.value = value;
      deleteNode(oldNode);
      setHead(oldNode);
    } else {
      Node newNode = new Node(key, value);
      if (map.size() >= capacity) {
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
    LRUCache cache = new LRUCache(5);
    cache.put(10, 100);
    cache.put(10, 100);
    cache.put(10, 100);
    cache.put(10, 100);
    cache.put(10, 100);
    cache.put(10, 100);


  }


}
