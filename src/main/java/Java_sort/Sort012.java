package Java_sort;

public class Sort012 {

  public static void sort(int arr[], int len){
    int cnt0=0, cnt1=0, cnt2=0;

    for(int i=0;i<len;i++){
      switch (arr[i]){
        case 0:
          cnt0++;
          break;
        case 1:
          cnt1++;
          break;
        case 2:
          cnt2++;
          break;
      }
    }
    int i=0;
    while (cnt0>0){
      arr[i++] =0;
      cnt0--;
    }
    while (cnt1>0){
      arr[i++] =1;
      cnt1--;
    }
    while (cnt2>0) {
      arr[i++] = 2;
      cnt2--;
    }
  }
  public static void printArray(int arr[]) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void main(String[] args) {
    int arr[] ={0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    int len =arr.length;
    sort(arr, len);
    printArray(arr);
  }
}
