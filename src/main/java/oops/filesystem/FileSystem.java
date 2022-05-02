package oops.filesystem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {

  private static class TrieNode {
    private String content = null;
    private Map<String, TrieNode> childNode = new TreeMap<>();
  }

  private final TrieNode root = new TrieNode();

  public List<String> ls(String path) {
    TrieNode curNode = root;
    if (!path.equals("/")) {
      //Find the directory
      String[] list = path.split("/");
      String curString;
      for (int i = 1; i < list.length; i++) {
        curString = list[i];
        curNode = curNode.childNode.get(curString);
        //Check if its file path
        if (i == list.length - 1 && curNode.content != null) {
          return Arrays.asList(curString);
        }
      }
    }
    List<String> childNodes = new LinkedList<>(curNode.childNode.keySet());
    return childNodes;
  }

  public void makeDir(String path) {
    TrieNode curNode = root;
    String[] list = path.split("/");
    for (int i = 1; i < path.length(); i++) {
      String curString = list[i];
      if (!curNode.childNode.containsKey(curString)) {
        curNode.childNode.put(curString, new TrieNode());
      }
      curNode = curNode.childNode.get(curString);
    }
  }

  public void addContentToFile(String filePath, String content) {
    TrieNode curNode = root;
    String[] arr = filePath.split("/");
    for (int i = 1; i < arr.length; i++) {
      String curString = arr[i];
      if (curNode.childNode.containsKey(curString)) {
        curNode.childNode.put(curString, new TrieNode());
      }
      curNode = curNode.childNode.get(curString);
    }
    if (curNode.content != null) {
      curNode.content += content;
    } else {
      curNode.content = content;
    }
  }

  public String readContentFromFile(String filePath) {
    TrieNode curNode = root;
    String[] arr = filePath.split("/");
    for (int i = 1; i < arr.length; i++) {
      String curString = arr[i];
      if (curNode.childNode.containsKey(curString)) {
        curNode.childNode.put(curString, new TrieNode());
      }
      curNode = curNode.childNode.get(curString);
    }
    return curNode.content;
  }
}
