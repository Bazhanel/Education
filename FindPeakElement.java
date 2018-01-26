import java.util.*;

public class FindPeakElement {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        java.io.PrintStream out = System.out;

        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        out.println(search(array));
    }

    public static int search(int[] array) {
        int start = 0;
        int end = array.length - 1;
        /* Проверка крайних точек массива*/
        if (array[0] > array[1]) return array[0];
        if (array[end] > array[end - 1]) return array[end];

        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1])
                return array[mid];
            if (array[mid] > array[mid - 1])
                start = mid;
            else end = mid;
        }

        return 0;
    }

}