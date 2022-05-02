package LowLoevelSystemDesign.chesslld.chess.helper;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ListHelper {

  public static <T> List<T> removeDuplicates(final List<T> list) {
    List<T> newList = new ArrayList<>();
    for (T element : list) {
      if (!newList.contains(element)) {
        newList.add(element);
      }
    }
    return newList;
  }

}
