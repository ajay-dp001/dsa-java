package leetcodeTopInterview.array;

public class RotateArray {

  public static void main(String[] args) {
    int k1 = 3;
    int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
    int k2 = 2;
    int[] arr2 = {-1, -100, 3, 99};

    rotate(arr1, k1);
    for (int num : arr1) {
      System.out.print(num + " ");
    }

    System.out.println();

    rotateFast(arr2, k2);
    for (int num : arr2) {
      System.out.print(num + " ");
    }
  }

  private static void rotate(int[] arr, int key) {
    int cnt = 0;
    while (cnt < key) {
      int tmp = arr[arr.length - 1];
      for (int i = arr.length - 1; i >= 1; i--) {
        arr[i] = arr[i - 1];
      }
      cnt++;
      arr[0] = tmp;
    }
  }

  private static void rotateFast(int[] arr, int key) {
    key = key % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, key - 1);
    reverse(arr, key, arr.length - 1);

  }

  private static void reverse(int[] arr, int left, int right) {
    while (left < right) {
      int temp = arr[left];
      arr[left++] = arr[right];
      arr[right--] = temp;
    }
  }

}
