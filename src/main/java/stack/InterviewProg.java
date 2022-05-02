package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class InterviewProg {

  static int count, max_count, max_len=1;
  static int min_new, min_old;

  public static void main(String[] args) {
    String str = "{abc{m{sa}sju}}{hg{e}f}";
    int len = str.length();
    printSmallest(str, len);
  }

  private static void printSmallest(String str, int len) {
    if (str != null && len > 0) {
      Stack<Character> stack = new Stack<>();
      Map<Integer, List<Character>> map = new HashMap<>();
      for (int i = 0; i < len - 1; i++) {
        char ch = str.charAt(i);
        if (ch == '{') {
          count++;
          max_count = count;
          stack.push(ch);
        } else if (ch == '}') {
          stack.pop();
          count--;
        } else {
          List<Character> characterList = map.get(count);
          if (characterList != null && characterList.size() > 0) {
            characterList.add(ch);
          } else {
            List<Character> list = new ArrayList<>();
            list.add(ch);
            map.put(count, list);
          }
        }
        if (count == 0) {
          count = max_count;
        }
      }
      System.out.println(map);
      for (Entry<Integer, List<Character>> entry: map.entrySet()){
        int size= entry.getValue().size();
        max_len = Math.min(size, max_len);
      }
      System.out.println(max_len);
    }
  }

  private static void printSmall(String str, int len) {
    if (str != null && len > 0) {
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < len - 1; i++) {
        char ch = str.charAt(i);
        if (ch == '{') {
          stack.push(ch);
        }else if(ch != '{' && ch != '}') {

        }
          else {
          stack.pop();
        }
      }
    }
  }
}
