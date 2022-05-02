package AAAMSPrepare.arrayInterviewBit;

public class MedianOFSortedArray {

  public static void main(String[] args) {
    int[] arr2 = {1, 4, 5};
    int[] arr1 = {2, 3};
    System.out.println(findMedian(arr1, arr2));

    int[] arr11 = {1, 2};
    int[] arr22 = {3, 4};
    System.out.println(findMedian(arr11, arr22));

    int[] arr111 = {2};
    int[] arr222 = {};
    System.out.println(findMedian(arr111, arr222));

  }

  private static double findMedian(int[] a, int[] b) {
    if (a.length > b.length) {
      return findMedian(b, a);
    }

    int x = a.length;
    int y = b.length;
    int lo = 0;
    int hi = x;

    while (lo <= hi) {
      int midX = (lo + hi) / 2;
      int midY = (x + y + 1) / 2 - midX;

      int xl = midX == 0 ? Integer.MIN_VALUE : a[midX - 1];
      int xr = midX == x ? Integer.MAX_VALUE : a[midX];

      int yl = midY == 0 ? Integer.MIN_VALUE : b[midY - 1];
      int yr = midY == y ? Integer.MAX_VALUE : b[midY];

      if (xl <= yr && yl <= xr) {
        if ((x + y) % 2 == 0) {
          return ((double) Math.max(xl, yl) + Math.min(xr, yr)) / 2;
        } else {
          return Math.max(xl, yl);
        }
      } else if (xl > yr) {
        hi = midX - 1;
      } else {
        lo = midX + 1;
      }
    }
    return 0;
  }


  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double mid = 0.0;

    int m = nums1.length;
    int n = nums2.length;

    int length = m + n;

    int left = -1, right = -1;

    int nums1start = 0, nums2start = 0;

    for (int i = 0; i <= length / 2; i++) {
      left = right;
      if (nums1start < m && (nums2start >= n || nums1[nums1start] < nums2[nums2start])) {
        right = nums1[nums1start++];
      } else {
        right = nums2[nums2start++];
      }
    }

    if (length % 2 == 0) {
      mid = (left + right) / 2.0;
    } else {
      mid = right;
    }

    return mid;

  }

}
