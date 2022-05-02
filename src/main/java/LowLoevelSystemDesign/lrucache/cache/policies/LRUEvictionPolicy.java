package LowLoevelSystemDesign.lrucache.cache.policies;

import java.util.HashMap;
import java.util.Map;
import LowLoevelSystemDesign.lrucache.cache.algo.DoublyLinkedList;
import LowLoevelSystemDesign.lrucache.cache.algo.DoublyLinkedListNode;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

  private final DoublyLinkedList<Key> dll;
  private final Map<Key, DoublyLinkedListNode<Key>> mapper;

  public LRUEvictionPolicy() {
    this.dll = new DoublyLinkedList<Key>();
    this.mapper = new HashMap<>();
  }

  @Override
  public void keyAccessed(Key key) {
    if (mapper.containsKey(key)) {
      dll.detachNode(mapper.get(key));
      dll.addNodeAtLast(mapper.get(key));
    } else {
      DoublyLinkedListNode<Key> ddlNode = dll.addElementAtLast(key);
      mapper.put(key, ddlNode);
    }
  }

  @Override
  public Key evictKey() {
    DoublyLinkedListNode<Key> first = dll.getFirstNode();
    if (first == null) {
      return null;
    }
    dll.detachNode(first);
    return first.getElement();
  }
}
