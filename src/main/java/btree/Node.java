package btree;

public class Node {

  public int key;
  public Node left, right, nextRight;
  public Integer val;

  public Node(int key) {
    this.key = key;
    left = right = nextRight = null;
  }
}

