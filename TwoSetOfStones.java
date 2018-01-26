import java.util.Scanner;

public class TwoSetOfStones {
    public static int minSum = 0;
    public static int totalW;
    public static int[] w ;
    public static int n;
   // public  static

    public static void Search(int qty, int currentWeigh) {
        if (qty == n) {
            int w2 = totalW - currentWeigh;
            int dif = Math.abs(currentWeigh - w2);
            if (dif < minSum)
                minSum = dif;
            return;
        }
        Search(qty + 1, currentWeigh + w[qty]);// qty количество взятых камней; currentWeigh - вес первой кучи
        Search(qty + 1, currentWeigh);
    }

    public static void find(int qty, int w1, int w2, String trail) {
        System.out.println(trail);
        if (qty == n) {
            int dif = Math.abs(w1 - w2);
            if (dif < minSum)
                minSum = dif;
            return;
        }
        find(qty + 1, w1 + w[qty], w2, trail+"1");// qty количество взятых камней; currentWeigh - вес первой кучи
        find(qty + 1, w1, w2 + w[qty],trail+"2");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            totalW += w[i];
        }
        minSum = totalW;
        Search(0, 0);
        System.out.println(minSum);
        find(0, 0,0, "");
        System.out.println(minSum);

    }
}
