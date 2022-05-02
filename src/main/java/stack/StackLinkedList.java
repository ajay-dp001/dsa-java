package stack;
/*
Created Stack Using LinkList
 */
public class StackLinkedList {

    Node root;

    private static class Node {

        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node tmp = root;
            root = newNode;
            newNode.next = tmp;
        }
    }

    public int pop() {
        int popped = Integer.MIN_VALUE;
        if (root == null) {
            System.out.println("Stack is Empty");
        } else {
            popped = root.data;
            root = root.next;
        }
        return popped;
    }

    public int peek() {
        if (root == null) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        } else {
            return root.data;
        }
    }

    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(10);
        stackLinkedList.pop();
        stackLinkedList.push(100);
        System.out.println(stackLinkedList.peek());
    }
}
