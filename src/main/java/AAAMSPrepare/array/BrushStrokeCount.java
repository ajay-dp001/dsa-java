package AAAMSPrepare.array;

public class BrushStrokeCount {

  public static void main(String[] args) {
    int[] arr = {1, 4, 3, 2, 3, 1};
    int ans1 = 5;
    int[] arr1 = {4, 1, 2, 1, 2, 2};
    int ans2 = 6;

    System.out.println("Brush Count:" + brushCnt(arr));
    System.out.println("Brush Count:" + brushCnt(arr1));
  }

  private static int brushCnt(int[] arr) {
    int bcnt = 0;
    int prvH = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > prvH) {
        bcnt += arr[i] - prvH;
      }
      prvH = arr[i];
    }
    return bcnt;
  }

}
