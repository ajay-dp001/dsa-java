package LowLoevelSystemDesign.lrucache.cachePrac.algo;

import LowLoevelSystemDesign.lrucache.exceptions.InvalidElementException;

public class DoublyLinkedList<E> {

  private DoublyLinkedListNode<E> head, tail;

  public DoublyLinkedList() {
    this.head = new DoublyLinkedListNode<>(null);
    this.tail = new DoublyLinkedListNode<>(null);
    head.next = tail;
    tail.prev = head;
  }

  public boolean isPresent() {
    return head.next != tail;
  }

  public void addNodeAtLast(final DoublyLinkedListNode<E> ddlNode) {
    DoublyLinkedListNode<E> tailPrev = tail.prev;
    tailPrev.next = ddlNode;
    ddlNode.prev = tailPrev;
    ddlNode.next = tail;
    tail.prev = ddlNode;
  }

  public void detachNode(final DoublyLinkedListNode<E> ddlNode) {
    if (ddlNode != null) {
      ddlNode.prev.next = ddlNode.next;
      ddlNode.next.prev = ddlNode.prev;
    }
  }

  public DoublyLinkedListNode<E> addElementAtLast(final E element) {
    if (element == null) {
      throw new InvalidElementException("Elem Null");
    }
    DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
    addNodeAtLast(newNode);
    return newNode;
  }

  public DoublyLinkedListNode<E> getFirstNode() {
    if (!isPresent()) {
      return null;
    }
    return head.next;
  }

  public DoublyLinkedListNode<E> getLastElement() {
    if (!isPresent()) {
      return null;
    }
    return tail.prev;
  }

}
