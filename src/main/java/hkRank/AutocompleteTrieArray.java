package hkRank;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteTrieArray {

  private final TrieNode rootNode;
  private static final int NUM_OF_CHARS = 128;

  private static class TrieNode {

    private boolean isEnd;
    private final char data;
    private final TrieNode[] children;

    //Constructor, Time O(1), Space O(1), 128 is constant
    public TrieNode(char ch) {
      this.data = ch;
      this.isEnd = false;
      this.children = new TrieNode[NUM_OF_CHARS];
    }
  }

  public AutocompleteTrieArray() {
    rootNode = new TrieNode(' ');
  }

  //Inserts a word into the trie, Iteration
  //Time O(s), Space O(s), s is word length
  public void insert(final String word) {
    TrieNode tempNode = rootNode;
    for (char ch : word.toCharArray()) {
      if (tempNode.children[ch] == null) {
        tempNode.children[ch] = new TrieNode(ch);
      }
      tempNode = tempNode.children[ch];
    }
    tempNode.isEnd = true;
  }

  //find the node with prefix's last char, then call helper to find all words using recursion
  //Time O(n), Space O(n), n is number of nodes included(prefix and branches)
  public List<String> autoComplete(String prefix) {
    TrieNode tempNode = rootNode;
    List<String> resultList = new ArrayList<>();
    for (char ch : prefix.toCharArray()) {
      tempNode = tempNode.children[ch];
      if (tempNode == null) {
        return new ArrayList<>();
      }
    }
    helper(tempNode, resultList, prefix.substring(0, prefix.length() - 1));
    return resultList;
  }

  //Time O(n), Space O(n), n is number of nodes in branches
  private void helper(TrieNode tempNode, List<String> resultList, String prefix) {
    if (tempNode == null) {
      return;
    }
    if (tempNode.isEnd) {
      resultList.add(prefix + tempNode.data);
    }
    for (TrieNode child : tempNode.children) {
      helper(child, resultList, prefix + tempNode.data);
    }
  }

  public static void main(String[] args) {
    AutocompleteTrieArray trie = new AutocompleteTrieArray();
    trie.insert("amazon");
    trie.insert("amazon prime");
    trie.insert("amazing");
    trie.insert("amazing spider man");
    trie.insert("amazed");
    trie.insert("apple");
    trie.insert("apple green");
    trie.insert("amaz");

    System.out.println(trie.autoComplete("amaz"));
  }
}
