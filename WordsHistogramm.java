/*
Given a string with words split by spaces, draw a vertical histogram of word lengths

Format
Input  {str}
Output {hist}

Example
Input: Lorem ipsum dolor sit amet
Output
          |
          |
    |  |  |
    3  4  5
*/

import java.util.Scanner;

public class WordsHistogramm {
    public static String lpad(String str, int length) {
        while (str.length() < length)
            str = " " + str;
        return str;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int maxLength = 0;
        int minLength = 1;
        int minRow = -1;
        String lastLine = "";
        for (String val : word.split("\\s+")) {
            if (maxLength <= val.length())
                maxLength = val.length();
            if (minLength >= val.length())
                minLength = val.length();
        }

        int[] words = new int[maxLength + 1];

        for (String val : word.split("\\s+")) {
            words[val.length()]++;
        }

        for (int i = 1; i < maxLength + 1; i++)
            if (words[i] > 0) {
                lastLine += lpad(String.valueOf(i), 3);
                if (minRow <= words[i])
                    minRow = words[i];
        }
        for (int j = maxLength + 1 - minRow; j < maxLength + 1; j++) {
            for (int i = 1; i < maxLength + 1; i++) {
                if (words[i] > 0) {
                    if (j == maxLength + 1 - words[i]) {
                        System.out.print("  |");
                        words[i]--;
                    } else {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println(lastLine);
    }

}