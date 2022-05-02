package hkRank;

public class CustomTrieImpl {

  private static class TrieNode {

    private boolean isEndOfWord;
    private TrieNode children[];

    private TrieNode() {
      isEndOfWord = false;
      children = new TrieNode[26];
    }
  }

  private TrieNode root;

  public CustomTrieImpl() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
      if (node.children[ch - 'a'] == null) {
        node.children[ch - 'a'] = new TrieNode();
      }
      node = node.children[ch - 'a'];
    }
    node.isEndOfWord = true;
  }

  public boolean search(String word) {
    return isMatch(word, root, 0, true);
  }

  public boolean startsWith(String prefix) {
    return isMatch(prefix, root, 0, false);
  }

  private boolean isMatch(String str, TrieNode trieNode, int index, boolean isFullMatch) {
    if (trieNode == null) {
      return false;
    }
    if (index == str.length()) {
      return !isFullMatch || trieNode.isEndOfWord;
    }

    return isMatch(str, trieNode.children[str.charAt(index) - 'a'], index + 1, isFullMatch);
  }

  public static void main(String[] args) {
    CustomTrieImpl trie = new CustomTrieImpl();
    trie.insert("cat");
    trie.insert("car");
    trie.insert("dog");
    trie.insert("pick");
    trie.insert("pickle");

    System.out.println(trie.search("cat"));
    System.out.println(trie.search("picky"));
    System.out.println(trie.startsWith("ca"));
    System.out.println(trie.startsWith("pen"));
  }
}
