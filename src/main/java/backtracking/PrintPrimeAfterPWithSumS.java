package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrintPrimeAfterPWithSumS {

  static List<Integer> set = new ArrayList<>();
  static List<Integer> primeSet = new ArrayList<>();

  public static void main(String[] args) {
    int sum = 54, num = 2, primeElem = 3;
    allPrimeSumAfterNum(num, primeElem, sum);
  }

  private static void allPrimeSumAfterNum(int num, int primeElem, int sum) {
    for (int i = primeElem + 1; i <= sum; i++) {
      if (isPrime(i)) {
        primeSet.add(i);
      }}
      if (primeSet.size() < primeElem) {
        return;
      }
      primeSum(0, num, sum, 0);

  }

  public static void display() {
    int len = set.size();
    for (int i = 0; i < len; i++) {
      System.out.print(set.get(i) + " ");
    }
    System.out.println();
  }

  private static void primeSum(int total, int num, int sum, int index) {
    if (total == sum && set.size() == num) {
      display();
      return;
    }

    if (total > sum || index == primeSet.size() || set.size() >= num) {
      return;
    }

    set.add(primeSet.get(index));
    primeSum(total + primeSet.get(index), num, sum, index + 1);

    set.remove(set.size() - 1);
    primeSum(total, num, sum, index + 1);
  }

  private static boolean isPrime(int num) {
    int sqroot = (int) Math.sqrt(num);
    if (num == 1) {
      return false;
    }
    for (int i = 2; i < sqroot; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

}
