package hkRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

  private static class TrieNode {

    private char ch;
    private boolean isString;
    private Map<Character, TrieNode> map;

    public TrieNode() {
      map = new HashMap<>();
    }

    public TrieNode(char ch) {
      this.ch = ch;
      map = new HashMap<>();
    }

    public void insert(String str) {
      if (str == null || str.isEmpty()) {
        return;
      }
      char first_ch = str.charAt(0);
      TrieNode child = map.get(first_ch);
      if (child == null) {
        child = new TrieNode(first_ch);
        map.put(first_ch, child);
      }
      if (str.length() > 1) {
        child.insert(str.substring(1));
      } else {
        child.isString = true;
      }
    }
  }

  private final TrieNode root;

  public Trie(List<String> words) {
    root = new TrieNode();
    for (String word : words) {
      root.insert(word);
    }
  }

  private List<String> suggest(String prefix) {
    List<String> list = new ArrayList<>();
    TrieNode lastNode = root;
    StringBuffer curr = new StringBuffer();
    for (char ch : prefix.toCharArray()) {
      lastNode = lastNode.map.get(ch);
      if (lastNode == null) {
        return list;
      }
      curr.append(ch);
    }
    suggestHelper(lastNode, list, curr);
    return list;
  }

  private void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
    if (root.isString) {
      list.add(curr.toString());
    }

    if (root.map == null || root.map.isEmpty()) {
      return;
    }

    for (TrieNode child : root.map.values()) {
      suggestHelper(child, list, curr.append(child.ch));
      curr.setLength(curr.length() - 1);
    }
  }

  public boolean find(String prefix) {
    return find(prefix, false);
  }

  public boolean find(String prefix, boolean exact) {
    TrieNode lastNode = root;
    for (char c : prefix.toCharArray()) {
      lastNode = lastNode.map.get(c);
      if (lastNode == null) {
        return false;
      }
    }
    return !exact || lastNode.isString;
  }

  public static void main(String[] args) {
    List<String> list = List.of("hello", "dog", "hell", "cat", "a", "hel", "help", "helps", "helping");
    Trie trie = new Trie(list);
    System.out.println(trie.suggest("hel"));
  }
}
