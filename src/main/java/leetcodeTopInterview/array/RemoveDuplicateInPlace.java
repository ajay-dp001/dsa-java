package leetcodeTopInterview.array;

public class RemoveDuplicateInPlace {

  public static void main(String[] args) {
    int[] arr4 = {0, 1, 2, 3, 3};
    int r1 = 1;
    int[] r = {1, 1};
    int res = 2;
    int[] arr = {1, 1, 2};
    int res1 = 5;
    int[] arr1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println("Result for 1st Array is : " + removeDuplicate(arr4));
    System.out.println("Result for 1st Array is : " + removeDuplicate(r));
    System.out.println("Result for 1st Array is : " + removeDuplicate(arr));
    System.out.println("Result for 2nd Array is : " + removeDuplicate(arr1));
  }

  private static int removeDuplicate(int[] arr) {
    int j = 1, len = arr.length;
    for (int i = 1; i < len; i++) {
      if (arr[i] != arr[i - 1]) {
        arr[j++] = arr[i];
      }
    }
    return j;
  }

  private static int removeDup(int[] arr) {
    int i = 1, j = 0;
    while (arr.length > i) {
      if (arr[i] != arr[j]) {
        arr[++j] = arr[i];
      }
      i++;
    }
    return j + 1;
  }

}
