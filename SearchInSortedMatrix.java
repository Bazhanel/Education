/*
The matrix has the following properties: - Elements in each row are sorted in ascending order from left to right. - Elements in each column are sorted in ascending order from top to bottom.

Write an efficient algorithm that searches for a value this matrix. You should proceed k queries. For each query return position of the value in matrix if found, print "NOT FOUND" in other case.

The first line of the input contains three numbers: m - number of rows in the matrix, n - number of columns, k - number of queries Next m lines contain n numbers each, that are elements of the matrix. Last line contain numbers for k queries.

Print the result of each query in separate line*/

import java.util.*;

public class SearchInSortedMatrix {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        java.io.PrintStream out = System.out;

        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        //int[][] matrix = new int[m][n];
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

       /* for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }*/
        for (int t = 0; t < k; t++) {
            int[] result = searchMatrix(matrix, in.nextInt());
            if (result != null) {
                out.printf("%d %d\n", result[0], result[1]);
            } else {
                out.println("NOT FOUND");
            }
        }
    }

    public static int[] searchMatrix(int[][] matrix, int target) {
        int length = matrix.length - 1;
        int[] result = new int[2];
        int i = 0, j = matrix[0].length -1 ;
        // element
        while (i < length && j >= 0) {
            if (matrix[i][j] == target) {
                result[0] = i;
                result[1] = j;
                return result;
            }
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return null;

    }
}

