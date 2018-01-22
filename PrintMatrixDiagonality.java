import java.util.*;

public class PrintMatrixDiagonality {

    public static void main(String[] args) {


        int[][] matrix = {
                {1,  2,  3,   4},
                {5,  6,  7,   8},
                {9,  10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };

        printMatrixDiagonally(matrix);
    }

    private static void printMatrixDiagonally(int[][] matrix) {

        int rowCount = matrix[0].length;
        int columnCount = matrix.length;

        for (int r = 0; r < rowCount; r++) {
            for (int row = 0, col = r; col >= 0 && row < columnCount; row++, col--) {
                System.out.print(matrix[row][col] + " ");
            }
            //System.out.println();
        }

        for (int c = 1; c < columnCount; c++) {
            for (int row = c, col = rowCount - 1; col >= 0 && row < columnCount; row++, col--) {
                System.out.print(matrix[row][col] + " ");
            }
            //System.out.println();
        }

    }

}