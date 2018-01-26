import java.util.*;

public class Solution {
  public static int maxLength = 10;
  public static int quant = 0;

  public static void find(String str) {
    int len = str.length();
    if (quant == 1) return;

    if (len == maxLength) {
      System.out.println(str);
      quant++;
      return;
    }
    for (int i = 1; i <= len / 2; i++) {
      String end = str.substring(len - i, len);
      String prev = str.substring(len - i * 2, len - i);
      if (end.equals(prev)) {
        return;
      }
    }

    find(str + "A");
    find(str + "B");
    find(str + "C");
  }

  public static void main(String[] args) {
    find("");

  }
}