package LowLoevelSystemDesign.lrucache.cachePrac.policies;

import LowLoevelSystemDesign.lrucache.cachePrac.algo.DoublyLinkedList;
import LowLoevelSystemDesign.lrucache.cachePrac.algo.DoublyLinkedListNode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

  private final DoublyLinkedList<K> ddl;
  private final Map<K, DoublyLinkedListNode<K>> mapper;

  public LRUEvictionPolicy() {
    this.ddl = new DoublyLinkedList<>();
    this.mapper = new ConcurrentHashMap<>();
  }

  @Override
  public void keyAccessed(K key) {
    if (mapper.containsKey(key)) {
      DoublyLinkedListNode<K> ddlNode = mapper.get(key);
      ddl.detachNode(ddlNode);
      ddl.addNodeAtLast(ddlNode);
    } else {
      DoublyLinkedListNode<K> ddlNode = ddl.addElementAtLast(key);
      mapper.put(key, ddlNode);
    }
  }

  @Override
  public K evictKey() {
    DoublyLinkedListNode<K> firstNode = ddl.getFirstNode();
    if (firstNode == null) {
      return null;
    }
    ddl.detachNode(firstNode);
    return firstNode.getElement();
  }


}
