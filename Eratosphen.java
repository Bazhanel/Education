/* Решето Эратосфена для поиска простых чисел*/

import java.util.*;
import java.lang.*;

public class Eratosphen {
  public static void main(String args[]) {
    int maxN = 100_000;
    int[] primes = new int[10_000];
    int primesCount = 0;

    for (int i = 2; i <= maxN; i++) {
      int maxDiv = (int) Math.sqrt(i);
      boolean isPrime = true;

      for (int divIndex = 0; primes[divIndex] <= maxDiv && divIndex < primesCount; divIndex++)

        if (i % primes[divIndex] == 0) {
          isPrime = false;
          break;
        }

      if (isPrime)
        primes[primesCount++] = i;
    }

    System.out.println(primesCount + ": " + primes[primesCount - 1]);
  }
}