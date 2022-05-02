package AAAFinalPrep.array;

public class MissingNum {

  public static void main(String[] args) {
    int[] arr = {6, 1, 2, 8, 3, 4, 7, 10, 5};
    int len = arr.length;
    System.out.println(missingNum(arr, len));
  }

  private static int missingNum(int[] arr, int len) {
    int sum = (len+1) * (len + 2) / 2;
    for (int num : arr) {
      sum -= num;
    }
    return sum;
  }

}
