package Java_sort;

public class MinimumLengthUnsortedSubArray {

  public static void main(String[] args) {
    int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
    int arr1[] = {1, 3, 2, 4, 5};
    int arr2[] = {1, 2, 3, 4, 5};
    int len= arr.length;
    int len1= arr1.length;
    int len2= arr2.length;
    findMinUnSortedArray(arr2, len2);
  }

  private static void findMinUnSortedArray(int[] arr, int len) {
    int smin_idx = 0, emax_idx=0;

    for (int i=0;i<len-1;i++){
      if(arr[i]>arr[i+1]){
        smin_idx=i;
        break;
      }
    }
    for (int j=len-1;j>=0;j--){
      if(arr[j]<arr[j-1]){
        emax_idx=j;
        break;
      }
    }
    
    int min = arr[smin_idx], max= arr[smin_idx];

    for (int i=smin_idx+1; i<=emax_idx;i++){
      if(arr[i]>max)
        max= arr[i];
      if(arr[i]< min)
        min= arr[i];
    }

    for (int i=0;i<smin_idx-1;i++){
      if (arr[i]>min) {
        smin_idx = i;
        break;
      }
    }
    for (int i=emax_idx+1;i<len-1;i++){
      if (arr[i]<max) {
        emax_idx = i;
        break;
      }
    }

    System.out.println(" The unsorted Subarray which makes the given array sorted lies"+
        "  between the indices "+smin_idx+" and "+emax_idx);
  }
}
