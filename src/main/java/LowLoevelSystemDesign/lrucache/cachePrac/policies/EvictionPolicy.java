package LowLoevelSystemDesign.lrucache.cachePrac.policies;

public interface EvictionPolicy<K> {

  void keyAccessed(K key);

  K evictKey();
}
