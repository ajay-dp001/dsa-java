package AAAMSPrepare.array;

public class ProductArrayExceptSelf {

  public static void main(String[] args) {
    int arr[] = {10, 3, 5, 0, 6, 2};
    int n = arr.length;

    System.out.println("The product array is : ");
    productArray(arr, n);

    System.out.println("The product array is : ");
    long[] arrResult = productArrayEff(arr, n);

    for (long el : arrResult) {
      System.out.print(el + " ");
    }
  }

  private static long[] productArrayEff(int[] arr, int len) {
    long prod = 1;
    long flag = 0;

    for (int i = 0; i < len; i++) {
      if (arr[i] == 0) {
        flag++;
      } else {
        prod *= arr[i];
      }
    }

    long[] arrNew = new long[len];

    for (int i = 0; i < len; i++) {
      if (flag > 1) {
        arrNew[i] = 0;
      } else if (flag == 0) {
        arrNew[i] = (prod / arr[i]);
      } else if (flag == 1 && arr[i] != 0) {
        arrNew[i] = 0;
      } else {
        arrNew[i] = prod;
      }
    }
    return arrNew;

  }

  private static void productArray(int[] arr, int len) {
    if (len == 1) {
      System.out.println(0);
      return;
    }
    int[] left = new int[len];
    int[] right = new int[len];
    int[] prod = new int[len];

    left[0] = 1;
    right[len - 1] = 1;

    for (int i = 1; i < len; i++) {
      left[i] = left[i - 1] * arr[i - 1];
    }

    for (int i = len - 2; i >= 0; i--) {
      right[i] = right[i + 1] * arr[i + 1];
    }

    for (int i = 0; i < len; i++) {
      prod[i] = left[i] * right[i];
    }

    for (int i = 0; i < len; i++) {
      System.out.print(prod[i] + " ");
    }
    return;
  }

}
