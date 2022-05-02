package LowLoevelSystemDesign.consistenthashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * To Hash Node Objects to a Hash Ring with a certain amount of Virtual Node. Method routeNode will return a
 * Node instance which the Object key should be allocated in accordance to Consistent Hash Algorithm.
 *
 * @param <T>
 */
public class ConsistentHashRouter<T extends Node> {

  private static class MD5Hash implements HashFunction {

    private MessageDigest instance;

    public MD5Hash() {
      try {
        instance = MessageDigest.getInstance("MD5");
      } catch (final NoSuchAlgorithmException ex) {
        System.out.println("No Such Algo" + ex.getMessage());
      }
    }

    @Override
    public Long hash(String key) {
      instance.reset();
      instance.update(key.getBytes(StandardCharsets.UTF_8));
      byte[] digest = instance.digest();

      long h = 0;
      for (int i = 0; i < 4; i++) {
        h <<= 8;
        h |= ((int) digest[i]) & 0XFF;
      }
      return h;
    }
  }

  private final HashFunction hashFunction;
  private final SortedMap<Long, VirtualNode<T>> hashRing = new TreeMap<>();

  public ConsistentHashRouter(final Collection<T> pNodes, final int vNodeCount) {
    this(pNodes, vNodeCount, new MD5Hash());
  }

  /**
   * @param pNodes       collection for Physical Nodes
   * @param vNodeCount   amount of Virtual Nodes
   * @param hashFunction hash Function to hash Node instance
   */
  public ConsistentHashRouter(final Collection<T> pNodes, final int vNodeCount,
      final HashFunction hashFunction) {
    if (hashFunction == null) {
      throw new NullPointerException("HashFunction is Null");
    }
    this.hashFunction = hashFunction;
    if (pNodes != null) {
      for (T pNode : pNodes) {
        addNodes(pNode, vNodeCount);
      }
    }
  }

  /**
   * Add Physical Node to the Hash Ring with some Virtual Nodes.
   *
   * @param pNode      Physical Node needs to be added to Hash Ring
   * @param vNodeCount Number of Virtual Node of the Physical Node, Value should be greater then 0
   */
  private void addNodes(final T pNode, final int vNodeCount) {
    if (vNodeCount <= 0) {
      throw new IllegalArgumentException("Illegal Virtual Node count :" + vNodeCount);
    }
    int existingReplicas = getExistingReplicas(pNode);
    for (int i = 0; i < vNodeCount; i++) {
      VirtualNode<T> vNode = new VirtualNode<>(pNode, i + existingReplicas);
      hashRing.put(hashFunction.hash(vNode.getKey()), vNode);
    }
  }

  /**
   * Remove Physical Node form Hash Ring.
   *
   * @param pNode PhysicalNode
   */
  public void remove(final T pNode) {
    Iterator<Long> itr = hashRing.keySet().iterator();
    while (itr.hasNext()) {
      Long key = itr.next();
      VirtualNode<T> virtualNode = hashRing.get(key);
      if (virtualNode.isVirtualNodeOf(pNode)) {
        itr.remove();
      }
    }
  }

  /**
   * With specified Key, route the nearest Node instance in the current Hash Ring.
   *
   * @param objectKey the ObjectKey to find a nearest Node
   * @return
   */
  public T routeNode(final String objectKey) {
    if (hashRing.isEmpty()) {
      return null;
    }
    Long hashVal = hashFunction.hash(objectKey);
    SortedMap<Long, VirtualNode<T>> tailMap = hashRing.tailMap(hashVal);
    Long nodeHashVal = !tailMap.isEmpty() ? tailMap.firstKey() : hashRing.firstKey();
    return hashRing.get(nodeHashVal).getPhysicalNode();
  }

  public int getExistingReplicas(final T pNode) {
    int replicas = 0;
    for (VirtualNode<T> vnode : hashRing.values()) {
      if (vnode.isVirtualNodeOf(pNode)) {
        replicas++;
      }
    }
    return replicas;
  }

}
