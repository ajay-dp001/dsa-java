package Arrays;

public class MaxProductSubArray {

  public static void main(String[] args) {
    int arr[] = {1, -2, -3, 0, 7, -8, -2};
    int ln = arr.length;
    int[] arr1 = {1,-2,-3,4};
    int len = arr1.length;
    int[] arr2 ={0,1,-2,-3,-4};
    int len2= arr2.length;
    System.out.println("Maximum Sub array product is " + maxSubarrayProduct(arr, ln));
    System.out.println("Maximum Sub array product is " + maxSubarrayProduct(arr, ln));
    System.out.println("Maximum Sub array product is " + maxPro(arr1, len));
    System.out.println("Maximum Sub array product is " + maxPro(arr2, len2));
  }

  private static int maxPro(int[] arr, int len) {
    int prefixProd = 1;
    int suffixProd = 1;
    int maxProd = arr[0];

    for (int i = 0; i < len; i++) {
      if (prefixProd == 0) {
        prefixProd = 1;
      }
      if (suffixProd == 0) {
        suffixProd = 1;
      }

      prefixProd = prefixProd * arr[i];
      suffixProd = suffixProd * arr[len - i - 1];
      maxProd = Math.max(maxProd, Math.max(prefixProd, suffixProd));
    }
    return maxProd;
  }

  private static int maxSubarrayProductEff(int[] arr, int ln) {
    int max_ending_here = 1, min_ending_here = 1, max_so_far = 0, flag = 0;
    for (int i = 0; i < ln; i++) {
      if (arr[i] > 0) {
        max_ending_here *= arr[i];
        min_ending_here = Math.max(max_ending_here * arr[i], 1);
        flag = 1;
      } else if (arr[i] == 0) {
        max_ending_here = 1;
        min_ending_here = 1;
      } else {
        int temp = max_ending_here;
        max_ending_here = Math.max(min_ending_here * arr[i], 1);
        min_ending_here = temp * arr[i];
      }
      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
      }
    }

    if (flag == 0 && max_so_far == 0) {
      return 0;
    }
    return max_so_far;
  }

  private static int maxSubarrayProduct(int[] arr, int ln) {
    int max = arr[0];
    for (int i = 0; i < ln; i++) {
      int prod = arr[i];
      for (int j = i + 1; j < ln; j++) {
        max = Math.max(max, prod);
        prod *= arr[j];
      }
      max = Math.max(max, prod);
    }
    return max;
  }


}
