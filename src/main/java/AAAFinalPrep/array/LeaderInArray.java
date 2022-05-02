package AAAFinalPrep.array;

public class LeaderInArray {

  public static void main(String[] args) {
    int arr[] = new int[]{16, 17, 4, 3, 5, 2};
    int n = arr.length;
    printLeadersEff(arr, n);
  }

  private static void printLeaders(int[] arr, int len) {
    for (int i = 0; i < len; i++) {
      int j;
      for (j = i + 1; j < len; j++) {
        if (arr[i] <= arr[j]) {
          break;
        }
      }
      if (j == len) {
        System.out.print(arr[i] + " ");
      }
    }
  }

  private static void printLeadersEff(int[] arr, int len) {
    int max_from_right = arr[len - 1];
    System.out.print(max_from_right + " ");

    for (int i = len - 2; i >= 0; i--) {
      if (max_from_right < arr[i]) {
        max_from_right = arr[i];
        System.out.print(max_from_right + " ");
      }
    }
  }

}
