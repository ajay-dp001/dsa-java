package Arrays;

public class FindTripletSum {

  public static void main(String[] args) {
    int arr[] = {1, 4, 45, 6, 10, 8};
    int sum = 22;
    int len = arr.length;
    findTripletSum(arr, len, sum);
    findTripletSumEfficient(arr, len, sum);

    int[] arr2 = {1, 2, 3, 5};
    int len2 = arr2.length;
    System.out.println("Max Triplet Sum is :" + maxTripletSum(arr2, len2));
  }

  private static int maxTripletSum(int[] arr, int len) {
    int maxA = 0, maxB = 0, maxC = 0;
    for (int i = 0; i < len; i++) {
      if (arr[i] > maxA) {
        maxC = maxB;
        maxB = maxA;
        maxA = arr[i];
      } else if (arr[i] > maxB) {
        maxC = maxB;
        maxB = arr[i];
      } else if (arr[i] > maxC) {
        maxC = arr[i];
      }
    }
    return maxA + maxB + maxC;
  }

  private static void findTripletSum(int[] arr, int len, int sum) {
    for (int i = 0; i < len - 2; i++) {
      for (int j = i + 1; j < len - 1; j++) {
        for (int k = j + 1; k < len; k++) {
          if (arr[i] + arr[j] + arr[k] == sum) {
            System.out.println("Triplet are Old:" + arr[i] + " " + arr[j] + " " + arr[k]);
          }
        }
      }
    }
  }

  private static boolean findTripletSumEfficient(int[] arr, int len, int sum) {
    quickSort(arr, 0, len - 1);
    for (int i = 0; i < len - 2; i++) {
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        if (arr[i] + arr[j] + arr[k] == sum) {
          System.out.println("Triplet are :" + arr[i] + " " + arr[j] + " " + arr[k]);
          return true;
        } else if (arr[i] + arr[j] + arr[k] < sum) {
          j++;
        } else {
          k--;
        }
      }
    }
    return false;
  }

  private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = findPivot(arr, low, high);
      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
  }

  private static int findPivot(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  private static void swap(int[] arr, int pos1, int pos2) {
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }
}
