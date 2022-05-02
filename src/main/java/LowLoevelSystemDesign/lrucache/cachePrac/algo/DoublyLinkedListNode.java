package LowLoevelSystemDesign.lrucache.cachePrac.algo;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {

  E element;
  DoublyLinkedListNode<E> prev, next;

  public DoublyLinkedListNode(E element) {
    this.element = element;
    prev = next = null;
  }

}
