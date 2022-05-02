package AAAFinalPrep.linkList;

public class QueueUsingLinkList {

  private static class QueueNode {

    int data;
    QueueNode next;

    public QueueNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  QueueNode front, rear;

  public QueueUsingLinkList() {
    this.front = this.rear = null;
  }

  public void enqueue(int data) {
    QueueNode node = new QueueNode(data);
    if (this.rear == null) {
      this.front = this.rear = node;
      return;
    }
    this.rear.next = node;
    this.rear = node;
  }

  public void dequeue() {
    if (this.front == null) {
      return;
    }
    QueueNode node = this.front;
    this.front = this.front.next;

    if (this.front == null) {
      this.rear = null;
    }
  }

}
