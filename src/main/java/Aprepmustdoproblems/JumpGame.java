package Aprepmustdoproblems;

public class JumpGame {

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 1, 4};
    System.out.println(jumpArr(arr));
  }

  public static int jumpArr(int[] arr) {
    int temp_last = 0, last = 0, cnt= 0;

    for (int i = 0; i < arr.length - 1; i++) {
      last = Math.max(last, i + arr[i]);
      if (i == temp_last) {
        cnt++;
        temp_last = last;
      }
    }
    return cnt;
  }

}
