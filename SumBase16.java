import java.util.*;

public class SumBase16 {
    public static final String alpha = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static int maxBase = alpha.length();
    public static int curBase = 16;

    public static int charToInt(char digit) {
        return alpha.indexOf(digit);
    }
    public static String SumBase(String A, String B) {
        Scanner in = new Scanner(System.in);
        //String A = "abcd";//in.nextLine();
        //String B = "0";//in.nextLine();
    String result="";
        int lenA = A.length();
        int lenB = B.length();
        int lenC = Math.max(lenA, lenB);

        char C[] = new char[lenC];

        for (int i = lenA; i < lenC; i++) A = "0" + A;

        for (int i = lenB; i < lenC; i++) B = "0" + B;

        int highest = 0;
        for (int i = lenC - 1; i >= 0; i--) {
            int sum = charToInt(A.charAt(i)) + charToInt(B.charAt(i)) + highest;
            highest = sum / curBase;
            C[i] = alpha.charAt(sum % curBase);
        }

        if (highest > 0)
        result = String.valueOf(highest);
        result += new String(C);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(SumBase("abcd","0"));
    }
}
