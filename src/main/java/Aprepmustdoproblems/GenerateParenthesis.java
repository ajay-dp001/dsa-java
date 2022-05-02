package Aprepmustdoproblems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

  public static void main(String[] args) {
    int input = 3;
    List<String> list = generateParenthesis(input);
    for (String str : list) {
      System.out.println(str);
    }
  }

  private static List<String> generateParenthesis(int input) {
    List<String> list = new ArrayList<>();
    findAll("(", 1, 0, list, input);
    return list;
  }

  private static void findAll(String current, int open, int close, List<String> list, int input) {
    if (current.length() == 2 * input) {
      list.add(current);
      return;
    }
    if (open < input) {
      findAll(current + "(", open + 1, close, list, input);
    }
    if (close < open) {
      findAll(current + ")", open, close + 1, list, input);
    }
  }

}
