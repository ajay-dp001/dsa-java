package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.List;

public class ItemsInContainer {

  public static void main(String[] args) {
    String str = "|**|*|*";
    String str1 = "*|*|*|";
    String str2 = "******|*|*";
    List<Integer> start_indices = new ArrayList<>(List.of(1, 1));
    List<Integer> end_indices = new ArrayList<>(List.of(5, 6));
    System.out.println(numberOfItems(str, start_indices, end_indices));

    List<Integer> start_indices1 = new ArrayList<>(List.of(1, 1));
    List<Integer> end_indices1 = new ArrayList<>(List.of(1, 6));
    System.out.println(numberOfItems(str1, start_indices1, end_indices1));

    List<Integer> start_indices2 = new ArrayList<>(List.of(1, 1));
    List<Integer> end_indices2 = new ArrayList<>(List.of(5, 6));
    System.out.println(numberOfItems(str2, start_indices2, end_indices2));
  }

  private static List<Integer> numberOfItems(String str, List<Integer> startIndices,
      List<Integer> endIndices) {
    String items = "";
    List<Integer> itemList = new ArrayList<>();
    for (int i = 0; i < Math.min(startIndices.size(), endIndices.size()); i++) {
      items = str.substring(startIndices.get(i) - 1, endIndices.get(i));
      char[] itemChars = items.toCharArray();
      int pair = 0;
      int cmpCount = 0;
      int totalCmpCount = 0;
      for (char itemChar : itemChars) {
        if (itemChar == '|' && pair == 0) {
          pair++;
          cmpCount = 0;
        } else if (itemChar == '|' && pair == 1) {
          if (cmpCount > 0) {
            totalCmpCount += cmpCount;
          }
          cmpCount = 0;
        } else if (itemChar == '*' && pair == 1) {
          cmpCount += 1;
        }
      }
      itemList.add(totalCmpCount);
    }
    return itemList;
  }

}
