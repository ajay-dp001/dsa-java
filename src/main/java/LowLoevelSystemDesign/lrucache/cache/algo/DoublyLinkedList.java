package LowLoevelSystemDesign.lrucache.cache.algo;

import LowLoevelSystemDesign.lrucache.exceptions.InvalidElementException;
import LowLoevelSystemDesign.lrucache.cache.exception.NotFoundException;

public class DoublyLinkedList<E> {

  DoublyLinkedListNode<E> head;
  DoublyLinkedListNode<E> tail;

  public DoublyLinkedList() {
    DoublyLinkedListNode<E> head = new DoublyLinkedListNode<>(null);
    DoublyLinkedListNode<E> tail = new DoublyLinkedListNode<>(null);
    head.next = tail;
    tail.prev = head;
  }

  public void addNodeAtLast(final DoublyLinkedListNode<E> ddlNode) {
    DoublyLinkedListNode<E> tailPrev = tail.prev;
    tailPrev.next = ddlNode;
    ddlNode.next = tail;
    tail.prev = ddlNode;
    ddlNode.prev = tailPrev;
  }

  public void detachNode(final DoublyLinkedListNode<E> ddlNode) {
    if (ddlNode != null) {
      ddlNode.prev.next = ddlNode.next;
      ddlNode.next.prev = ddlNode.prev;
    }
  }

  public DoublyLinkedListNode<E> addElementAtLast(E element) {
    if (element == null) {
      throw new InvalidElementException("Element is Null");
    }
    DoublyLinkedListNode<E> ddlNode = new DoublyLinkedListNode<>(element);
    addNodeAtLast(ddlNode);
    return ddlNode;
  }

  public boolean isPresent() {
    return head.next != tail;
  }

  public DoublyLinkedListNode<E> getFirstNode() throws NotFoundException {
    if (!isPresent()) {
      return null;
    }
    return head.next;
  }

  public DoublyLinkedListNode<E> getLastNode() throws NotFoundException {
    if (!isPresent()) {
      return null;
    }
    return tail.prev;
  }

}
