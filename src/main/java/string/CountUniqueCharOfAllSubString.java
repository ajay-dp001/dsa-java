package string;

//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
public class CountUniqueCharOfAllSubString {

  public static void main(String[] args) {
    String str = "leetcode";
    System.out.println(countUnique(str));
  }

  private static int countUnique(String s) {
    int n = s.length();
    int res = 0;

    for (int i = 0; i < n; i++) {
      int l = i - 1;
      while (l >= 0) {
        if (s.charAt(l) == s.charAt(i)) {
          break;
        }
        l--;
      }
      int r = i + 1;
      while (r < n) {
        if (s.charAt(r) == s.charAt(i)) {
          break;
        }
        r++;
      }
      res += (r - i) * (i - l);
    }
    return res;
  }

}
