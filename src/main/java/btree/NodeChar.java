package btree;

public class NodeChar {

  public char key;
  public NodeChar left, right;

  public NodeChar(char data) {
    key = data;
    left = right = null;
  }

}
