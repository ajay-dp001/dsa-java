package leetcodeTopInterview.strings;

public class ValidAnagaram {

  public static void main(String[] args) {
    String str11 = "nagaram";
    String str22 = "anagram";
    String str1 = "rat";
    String str2 = "car";
    System.out.println("Is valid Anagram :" + isValidAnagram(str1, str2));
  }

  private static boolean isValidAnagram(String s1, String s2) {
    int[] alphabet = new int[26];
    if (s1.length() != s2.length()) {
      return false;
    }
    for (int i = 0; i < s1.length(); i++) {
      alphabet[s1.charAt(i) - 'a']++;
      alphabet[s2.charAt(i) - 'a']--;
    }
    for (int num : alphabet) {
      if (num != 0) {
        return false;
      }
    }
    return true;
  }

  private static boolean isValidAnagramEff(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }
    int[] sf = freq(s1.toCharArray());
    int[] tf = freq(s2.toCharArray());

    for (int i = 0; i < tf.length; i++) {
      if (tf[i] != sf[i]) {
        return false;
      }
    }
    return true;
  }

  private static int[] freq(char[] chars) {
    int[] f = new int[26];

    for (int i = 0; i < chars.length; i++) {
      f[chars[i] - 'a']++;
    }

    return f;
  }

  public boolean isAnagram(String s, String t) {
    int[] map = new int[26];
    for (char c : s.toCharArray()) {
      map[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      map[c - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (map[i] != 0) {
        return false;
      }
    }
    return true;
  }

}
