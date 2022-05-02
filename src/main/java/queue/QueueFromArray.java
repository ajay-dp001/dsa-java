package queue;

public class QueueFromArray {

  private static class MyCustomQueue<T> {

    private static int front = 0;
    private static int rear = 0;
    private int capacity = 0;
    private static int[] queue;

    MyCustomQueue(int cap) {
      capacity = cap;
      queue = new int[capacity];
      front = rear = 0;
    }

    private void queueEnqueue(int val) {
      if (capacity == rear) {
        System.out.println("Queue is Full.!");
      } else {
        queue[rear++] = val;
      }
    }

    private void queueFront() {
      if (front == rear) {
        System.out.println("Queue is Empty.!");
      } else {
        System.out.println(queue[front]);
      }
    }


    private void queueDequeue() {
      if (front == rear) {
        System.out.println("Queue is Empty.!");
      } else {
        for (int i = 0; i < rear; i++) {
          queue[i] = queue[i + 1];
        }
        if (rear < capacity) {
          queue[rear] = 0;
        }
        rear--;
      }
    }

    private void queueDisplay() {
      if (front == rear) {
        System.out.println("Queue is Empty..!");
      } else {
        for (int i = front; i < rear; i++) {
          System.out.print(queue[i] + " ");
        }
        System.out.println();
      }
    }
  }


  public static void main(String[] args) {
    MyCustomQueue<Integer> qu = new MyCustomQueue(10);
    qu.queueDisplay();
    qu.queueEnqueue(20);
    qu.queueEnqueue(30);
    qu.queueEnqueue(40);
    qu.queueEnqueue(50);
    // print Queue elements
    qu.queueDisplay();
    // insert element in the queue
    qu.queueEnqueue(60);
    // print Queue elements
    qu.queueDisplay();

    qu.queueDequeue();
    qu.queueDequeue();
    System.out.printf("\nAfter two node deletion\n");

    // print Queue elements
    qu.queueDisplay();
    // print front of the queue
    qu.queueFront();
  }
}
