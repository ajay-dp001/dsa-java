package prac;

public class MatrixDigonalSum {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    printDigonalSum(matrix, 4);
  }

  private static void printDigonalSum(int[][] matrix, int size) {
    int principal = 0, secondary = 0;
    for (int i = 0; i < size; i++) {
      System.out.print(i);
      System.out.println(size-i-1);
      principal += matrix[i][i];
      secondary += matrix[i][size - i - 1];
    }
    System.out.println("Principal Sum " + principal);
    System.out.println("Secondary Sum " + secondary);
  }
}
