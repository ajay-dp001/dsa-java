package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitSpringIntoUniquePrimeNumbers {

  private static Set<Integer> set = new HashSet<>();

  public static void main(String[] args) {
    String str1 = "31173";
    String str2 = "3175";
    System.out.println("Number of Ways :" + findNumOfWays(str1));
    System.out.println("Number of Ways :" + findNumOfWays(str2));
  }

  private static int findNumOfWays(String str) {
    List<List<Integer>> ways = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    findPermutations(str, ways, result);
    return ways.size();
  }

  private static void findPermutations(String suffix, List<List<Integer>> resultSet, List<Integer> result) {
    if (suffix.length() == 0) {
      resultSet.add(new ArrayList<>(result));
      System.out.println(result.toString());
      return;
    }

    for (int i = 0; i < suffix.length(); i++) {
      String snum = suffix.substring(0, i + 1);
      int num = Integer.parseInt(snum);
      boolean isPrime = isPrime(num);
      if (isPrime) {
        result.add(num);
        findPermutations(suffix.substring(i + 1), resultSet, result);
        result.remove(result.size() - 1);
      }
    }
  }

  private static boolean isPrime(int num) {
    if (set.contains(num)) {
      return true;
    }
    boolean isPrime = isPrimeUtil(num);
    if (isPrime) {
      set.add(num);
    }
    return isPrime;
  }

  private static boolean isPrimeUtil(int num) {
    if (num < 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    if (num % 2 == 0) {
      return false;
    }
    for (int i = 3; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

}
