import java.util.*;

public class Solution {
  public static int maxLength = 8;
  public static int quant = 0;
  public static int numRuns = 0;

  public static void find(String str) {
    numRuns++;
    int len = str.length();

    //if (str.length() == 0) return;

    if (len > 0) {

      int lastX = len - 1;
      int lastY = str.charAt(len - 1) - '0';

      for (int i = 0; i < len - 1; i++) {

        int currentX = i;
        int currentY = str.charAt(i) - '0';

        if (currentY == lastY) {
          return;
        }

        if (currentX + currentY == lastX + lastY) {
          return;
        }
        if (currentX - currentY == lastX - lastY) {
          return;
        }
      }
      if (len == 8) {
        quant++;
        System.out.println(str + " " + quant);
      }

    }

    for (char i = '0'; i < '8'; i++) {
      find(str + i);
    }

  }

  public static void main(String[] args) {
    find("");
    System.out.println(quant);

  }
}
