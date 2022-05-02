package stack;

public class StackNQueueFromDeque {

    private static class DQueueNode {

        int value;
        DQueueNode next;
        DQueueNode prev;
    }

    private static class Deque {

        private DQueueNode head;
        private DQueueNode tail;

        public Deque() {
            head = tail = null;
        }

        public boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        public int size() {
            if (!isEmpty()) {
                int len = 0;
                DQueueNode temp = head;
                while (temp != null) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            return 0;
        }

        public void insertFirst(int data) {
            DQueueNode temp = new DQueueNode();
            temp.value = data;
            if (isEmpty()) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
        }

        public void insertLast(int data) {
            DQueueNode temp = new DQueueNode();
            temp.value = data;
            if (isEmpty()) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                tail.next = temp;
                temp.next = null;
                temp.prev = tail;
                tail = temp;
            }
        }

        public void removeFirst() {
            if (!isEmpty()) {
                DQueueNode temp = head;
                head = head.next;
                head.prev = null;
                return;
            }
            System.out.println("List is Empty");
        }

        public void removeLast() {
            if (!isEmpty()) {
                DQueueNode temp = tail;
                tail = tail.prev;
                tail.next = null;
                return;
            }
            System.out.println("List is Empty");
        }

        public void display() {
            if (!isEmpty()) {
                DQueueNode temp = head;
                while (temp != null) {
                    System.out.println(temp.value);
                    temp = temp.next;
                }
                return;
            }
            System.out.println("List is Empty");
        }
    }

    private static class Stack {

        Deque deque = new Deque();

        public void push(int data) {
            deque.insertLast(data);
        }

        public int size() {
            return deque.size();
        }

        public void pop() {
            deque.removeLast();
        }

        public void display() {
            deque.display();
        }
    }

    private static class Queue {

        Deque deque = new Deque();

        public void enqueue(int data) {
            deque.insertLast(data);
        }

        public void dequeue() {
            deque.removeFirst();
        }

        public void display() {
            deque.display();
        }

        public int size() {
            return deque.size();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.display();
        stack.push(30);
        stack.pop();
        stack.push(40);
        stack.display();
        stack.push(50);
        System.out.println("Size of Stack is :" + stack.size());

        Queue queue = new Queue();
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        queue.dequeue();
        queue.enqueue(60);
        System.out.println("Size of Queue  is :" + queue.size());
    }
}
