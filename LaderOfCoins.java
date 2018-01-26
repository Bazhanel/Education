import java.util.*;

public class LaderOfCoins {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        java.io.PrintStream out = System.out;
        long n = in.nextLong();
        out.println(search(n));
    }

    /* // Мое рещение
        public static long search(long n) {
            int nsum=0;
            int i=1;
            while (nsum <= n-i ){
                nsum = nsum + i;
                i++;
            }
            return i-1;
        }
    */
    public static long search(long n) {
        long start = 1;
        long end = n;
        while (start < end) {
            long mid = (start + end) / 2;
            long size_k = mid * (mid + 1) / 2;
            long size_l = (mid + 1) * (mid + 2) / 2;
            if (n >= size_k && n < size_l) {
                return mid;
            }
            if (n < size_k)
                end = mid;
            else
                start = mid;
        }
        return 0;
    }
}