import java.util.*;

public class MultiplyPrimeNumberPolindrome {

    private static final boolean reverse(long value) {
        String str = String.valueOf(value);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    private static final boolean isPrime(int n) {
        int i;
        if (n==1) return false;
        if (n==2 || n==3)return true;
        if (n%2==0) return false;
        for (i = 3; i*i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSimple (int k) {
        if (k % 2 == 0 && k != 2) return false;
        int maxDiv = (int) Math.sqrt(k);
        for (int i = 3; i <= maxDiv; i += 2) {
            if (k % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int i= 0;
        int maxPrimeNumber = 99999;
        int minPrimeNumber = 10000;

        outer:
        for (i = maxPrimeNumber; i >= minPrimeNumber; i--) {
            if (isSimple(i)){
                for (int j = i; j >= minPrimeNumber; j--) {
                    if (isSimple(j)) {
                        long cast = ((long) j) * i;
                        if (reverse(cast)) {
                            System.out.printf("%d * %d = %d%n", i, j, cast);
                            break outer;
                        }
                    }
                }
            }
        }
    }
}

