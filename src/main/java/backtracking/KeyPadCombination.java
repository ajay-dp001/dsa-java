package backtracking;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {

  final static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

  public static void main(String[] args) {
    String str = "678";
    List<String> list = getKeyPadCombination(str);
    System.out.println(list);

    getKeyPadCombinationEff(str, " ");
  }

  private static void getKeyPadCombinationEff(String str, String ans) {
    if (str.length() == 0) {
      System.out.print(ans+" ");
      return;
    }
    char ch = str.charAt(0);
    String restOfString = str.substring(1);

    String codeForCh = codes[ch - '0'];

    for (int i = 0; i < codeForCh.length(); i++) {
      char chCode = codeForCh.charAt(i);
      getKeyPadCombinationEff(restOfString, ans + chCode);
    }
  }

  public static List<String> getKeyPadCombination(String str) {
    if (str.length() == 0) {
      List<String> resultList = new ArrayList<>();
      resultList.add("");
      return resultList;
    }

    char ch = str.charAt(0);
    String restOfString = str.substring(1);
    List<String> recResult = getKeyPadCombination(restOfString);

    List<String> myResult = new ArrayList<>();

    String codeForCh = codes[ch - '0'];
    for (int i = 0; i < codeForCh.length(); i++) {
      char chCode = codeForCh.charAt(i);
      for (String rstr : recResult) {
        myResult.add(chCode + rstr);
      }
    }

    return myResult;
  }
}
