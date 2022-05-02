package string;

public class FirstIndex {

  public static void main(String[] args) {
    String str = "leetcode";
    System.out.println("First Index :" + firstUniqChar(str));
  }

  public static int firstUniqChar(String s) {
    int min = Integer.MAX_VALUE;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      int idx = s.indexOf(ch);
      if (idx != -1 && idx == s.lastIndexOf(ch)) {
        min = Math.min(min, idx);
      }
    }
    if (min == Integer.MAX_VALUE) {
      return -1;
    }
    return min;
  }

}
