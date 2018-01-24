import java.util.Scanner;

public class MinimalTrianglePath {
  public static int getPath(int[][] arr, int col, int row) {
    int result = arr[row][col];
    if (row != arr[0].length - 1) {
      int leftMove = getPath(arr, col, row + 1);
      int rightMove = getPath(arr, col + 1, row + 1);
      result += Math.min(leftMove, rightMove);
    }
    return result;
  }

  public static int TrianglePath(int[][] arr, int row, int col, int sum) {
    if (row == arr[0].length - 1)
      return sum + arr[row][col];
    else {
      int leftMove = TrianglePath(arr, row + 1, col, sum + arr[row][col]);
      int rightMove = TrianglePath(arr, row + 1, col + 1, sum + arr[row][col]);
      return Math.min(leftMove, rightMove);
    }
  }

  public static int TrianglePath2(int[][] arr){
    for (int i = arr[0].length - 1; i > 0; i--)
      for (int j = 0; j < arr[0].length - 1; j++)
        arr[i - 1][j] += Math.min(arr[i][j], arr[i][j + 1]);
    return arr[0][0];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int lineCount = in.nextInt();
    int[][] arr = new int[lineCount][lineCount];
    for (int i = 0; i < lineCount; i++) {
      for (int j = 0; j < i + 1; j++)
        arr[i][j] = in.nextInt();
    }
    //System.out.println(TrianglePath(arr, 0, 0, 0));
    System.out.println(TrianglePath2(arr));
  }

}