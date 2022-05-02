package AAAMSPrepare.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {

  private final TrieNode root = new TrieNode();

  private static class TrieNode {

    private String content = null;
    private Map<String, TrieNode> childNode = new TreeMap<>();
  }

  private void addContentToFile(String fiePath, String content) {
    TrieNode currNode = root;
    String[] paths = fiePath.split("/");
    for (int i = 0; i < paths.length; i++) {
      String tempPath = paths[i];
      if (currNode.childNode.containsKey(tempPath)) {
        currNode.childNode.put(tempPath, new TrieNode());
      }
      currNode = currNode.childNode.get(tempPath);
    }
  }

  public List<String> ls(String path) {
    TrieNode currNode = root;
    if (!path.equals("/")) {
      //Find the directory
      String[] dirPaths = path.split("/");
      String currPath;
      for (int i = 0; i < dirPaths.length; i++) {
        currPath = dirPaths[i];
        currNode = currNode.childNode.get(currPath);
        if (i == dirPaths.length - 1 && currNode.childNode != null) {
          return new ArrayList<>(currNode.childNode.keySet());
        }
      }
    }
    List<String> rootChildNodes = new LinkedList<>(currNode.childNode.keySet());
    return rootChildNodes;
  }

  public void makeDir(String path) {
    TrieNode currNode = root;
    String[] paths = path.split("/");
    for (int i = 0; i < paths.length; i++) {
      String tempPath = paths[i];
      if (!currNode.childNode.containsKey(tempPath)) {
        currNode.childNode.put(tempPath, new TrieNode());
      }
      currNode = currNode.childNode.get(tempPath);
    }
  }


}
