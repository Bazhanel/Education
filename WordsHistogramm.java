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
    public static String lpad(String str, String pad, int length) {
        while (str.length() < length)
            str = pad + str;
        return str;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = "U1  Pl  qQg1KDJ IzSXjCrj7  KOgb wa  NDhy 1L1  QJlJWXjOe  SJ8Y4RT l9H3kocDS  wC  jzCp J1  qGwmW 9e3xUrQqaC  u2u  kE rE mDJLEIMGMI  pp bf83OGG zYR8q  z5I  xr  wN  N4d r0jxYMM0c8 Ib2JDgvV  sZ  8Ud  MeFmdumLAN  XHKvsnJVU8 c2U  KACAw9Kg tFnA hhdKIgB  3Z 9I";//in.nextLine();
        int maxLength = 0;
        int minRow = -1;
        String lastLine = "";
        for (String val : word.split("\\s+")) {
            if (maxLength <= val.length())
                maxLength = val.length();
        }

        int[] words = new int[maxLength + 1];

        for (String val : word.split("\\s+")) {
            words[val.length()]++;
        }

        for (int i = 1; i < maxLength + 1; i++)
            if (words[i] > 0) {
                lastLine += lpad(String.valueOf(i)," ", 3);
                if (minRow <= words[i])
                    minRow = words[i];
        }
        System.out.println(minRow);
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