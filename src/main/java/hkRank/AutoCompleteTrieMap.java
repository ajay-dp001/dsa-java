package hkRank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AutoCompleteTrieMap {

  private static class TrieNode {

    private boolean isEnd;
    private final char data;
    private final Map<Character, TrieNode> childrenMap;

    // Constructor, Time O(1), Space O(1)
    public TrieNode(char ch) {
      this.data = ch;
      this.isEnd = false;
      this.childrenMap = new HashMap<>();
    }
  }

  private final TrieNode rootNode;

  public AutoCompleteTrieMap() {
    rootNode = new TrieNode(' ');
  }


  // Add a word to trie, Iteration, Time O(s), Space O(s), s is word length
  public void insert(final String word) {
    TrieNode tempNode = rootNode;
    for (char ch : word.toCharArray()) {
      if (!tempNode.childrenMap.containsKey(ch)) {
        tempNode.childrenMap.put(ch, new TrieNode(ch));
      }
      tempNode = tempNode.childrenMap.get(ch);
    }
    tempNode.isEnd = true;
  }

  //Remove a word from trie, Iteration, Time O(s), Space O(1), s is word length
  public void delete(final String word) {
    if (!search(word)) {
      System.out.println(word + " does not exist in Trie !!");
      return;
    }
    TrieNode tempNode = rootNode;
    for (char ch : word.toCharArray()) {
      if (!tempNode.childrenMap.containsKey(ch)) {
        return;
      }
      tempNode = tempNode.childrenMap.get(ch);
    }
    tempNode.isEnd = false;
  }

  private boolean search(String word) {
    TrieNode tempNode = rootNode;
    for (char ch : word.toCharArray()) {
      if (!tempNode.childrenMap.containsKey(ch)) {
        return false;
      }
      tempNode = tempNode.childrenMap.get(ch);
    }
    return tempNode.isEnd;
  }

  private void printTrie() {
    List<String> rls = new ArrayList<>();
    printHelper(rootNode, rls, "");
    System.out.println(rls);
  }

  private static void printHelper(TrieNode tempNode, List<String> rls, String prefix) {
    if (tempNode.isEnd) {
      String word = prefix + tempNode.data;
      rls.add(word.substring(1));
    }
    for (Character ch : tempNode.childrenMap.keySet()) {
      printHelper(tempNode.childrenMap.get(ch), rls, prefix + tempNode.data);
    }
  }

  //find all word with given prefix
  //Time O(n), Space O(n), n is number of nodes involved (include prefix and branches)
  public List<String> autoComplete(String prefix) {
    TrieNode tempNode = rootNode;
    List<String> resultList = new LinkedList<>();
    for (char ch : prefix.toCharArray()) {
      if (tempNode.childrenMap.containsKey(ch)) {
        tempNode = tempNode.childrenMap.get(ch);
      } else {
        return resultList;
      }
    }
    helper(tempNode, resultList, prefix.substring(0, prefix.length() - 1));
    return resultList;
  }

  // recursive function called by autocomplete
  //Time O(n), Space O(n), n is number of nodes in branches
  private void helper(TrieNode tempNode, List<String> resultList, String prefix) {
    if (tempNode.isEnd) {
      resultList.add(prefix + tempNode.data);
    }
    for (char ch : tempNode.childrenMap.keySet()) {
      helper(tempNode.childrenMap.get(ch), resultList, prefix + tempNode.data);
    }
  }

  public static void main(String[] args) {
    AutoCompleteTrieMap trie = new AutoCompleteTrieMap();
    trie.insert("amazon");
    trie.insert("amazon prime");
    trie.insert("amazing");
    trie.insert("amazing spider man");
    trie.insert("amazed");
    trie.insert("apple");
    trie.insert("apple green");
    trie.insert("amaz");

    System.out.println(trie.autoComplete("amaz"));
    System.out.println(trie.autoComplete("ap"));
    trie.printTrie();
  }

}
