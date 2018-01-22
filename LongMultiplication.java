import java.util.*;

public class LongMultiplication {
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
        String result = "";
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
        //System.out.print(new String(C));

        return result;
    }

    public static String Pad(int length) {
        String str = "";
        while (str.length() < length) {
            str += "0";
        }
        return str;
    }

    public static String MultiplyBase(String A, String B) {
        Scanner in = new Scanner(System.in);

        String result = "";
        int lenA = A.length();
        int lenB = B.length();
        int len = Math.max(lenA, lenB);

        for (int i = lenA; i < len; i++) A = "0" + A;
        int pad = 0;
        for (int i = lenB; i < len; i++) B = "0" + B;

        String highest = "";
        String val = "";
        StringBuilder sb = new StringBuilder();
        for (int j = len - 1; j >= 0; j--) {
            for (int i = len - 1; i >= 0; i--) {
                int sum = charToInt(A.charAt(i)) * charToInt(B.charAt(j)) + alpha.indexOf(highest);
                highest = String.valueOf(sum / curBase);
                sb.append(alpha.charAt(sum % curBase));
            }
            if (highest.length() > 0)
                sb.append(highest);
            highest = "";
            result = SumBase(result, sb.reverse().append(Pad(pad)).toString());
            sb = new StringBuilder();
            pad++;
        }

        return result.toUpperCase(); //16E80B3A

    }

    public static void main(String[] args) {
        String A = "abcd";//in.nextLine();
        String B = "2222";//in.nextLine(); 1579A
        System.out.println(SumBase(A, B).toUpperCase());
        System.out.println(MultiplyBase(A, B));
    }
}