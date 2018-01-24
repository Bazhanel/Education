import java.util.Scanner;

public class WordInMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String word = in.next();
        String temp;
        String[] input = new String[length];
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();

        for (int i = 0; i < length; i++) {
            input[i] = in.next();
            sb.append(input[i]);

        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(input[j].charAt(i));
            }
        }

        if (sb.indexOf(word) > -1 || sb.reverse().indexOf(word) > -1) {
            System.out.println("contains");
            return;
        }
        System.out.println("doesn't contain");
    }
}