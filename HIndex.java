import java.util.*;

public class HIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] citations = new int[N];

        for (int i = 0; i < N; i++) {
            citations[i] = in.nextInt();
        }

        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        int start=0;
        int end=citations.length-1;
        while (start<end ){
            int mid = (start+end)/2;


        }


        return 0;
    }

}