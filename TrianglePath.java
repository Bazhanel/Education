import java.util.*;

public class TrianglePath {
    static int M[][] = {
            { 75, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { 95, 64, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            { 17, 47, 82, -1, -1, -1, -1, -1, -1, -1, -1},
            { 18, 35, 87, 10, -1, -1, -1, -1, -1, -1, -1},
            { 20, 04, 82, 47, 65, -1, -1, -1, -1, -1, -1},
            { 19, 01, 23, 75, 03, 34, -1, -1, -1, -1, -1},
            { 88, 02, 77, 73, 07, 63, 67, -1, -1, -1, -1},
            { 99, 65, 04, 28, 06, 16, 70, 92, -1, -1, -1},
            { 41, 41, 26, 56, 83, 40, 80, 70, 33, -1, -1},
            { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29, -1},
            { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14}
    };

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
        int leftMove=0, rightMove =0;
        if (row == arr[0].length - 1)
            return sum + arr[row][col];
        else {
                leftMove = TrianglePath(arr, row + 1, col, sum + arr[row][col]);
                rightMove = TrianglePath(arr, row + 1, col + 1, sum + arr[row][col]);
            }
            return Math.min(leftMove, rightMove);
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
        //System.out.println(TrianglePath(arr, lineCount, lineCount, 0));
       // System.out.println(getPath2(arr));
    }
}