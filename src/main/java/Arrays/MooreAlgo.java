package Arrays;

public class MooreAlgo {

  public static void main(String[] args) {
    int[] arr = {7, 7, 5, 7, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
    int cnt = 0, elem = 0;
    for (int num : arr) {
      if (cnt == 0) {
        elem = num;
      }
      if (num == elem) {
        cnt++;
      } else {
        cnt--;
      }
    }
    System.out.println(elem);
  }

}
