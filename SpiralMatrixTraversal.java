import java.util.*;
import java.lang.*;

class Rextester
{
    public static void main(String args[]) {
        int W = 6;
        int H = 4;
        universal(0, 0, W - 1, H - 1, "u+r+d-l-");
    }

    public static void out(int cY, int cX) {
        System.out.println("    [" + cY + "_" + cX + "]");
    }

    public static void universal(int paramA, int paramB, int paramC, int paramD, String CommandsLine) {
        int startRow = paramA;
        int startCol = paramB;
        int endRow   = paramC;
        int endCol   = paramD;
        int commandCount = CommandsLine.length() / 2;
        while (true) {
            for (int commandNumber = 0; commandNumber < commandCount; commandNumber++) {
                char location  = CommandsLine.charAt(commandNumber * 2);
                char direction = CommandsLine.charAt(commandNumber * 2 + 1);
                // по горизонтали или вертикали
                if (location == 'u' || location == 'd') { // по горизонтали
                    int coordY = location  == 'u' ? startRow : endRow;
                    int beginX = direction == '+' ? startCol : endCol;
                    int deltaX = direction == '+' ? +1 : -1;

                    for (int coordX = beginX; coordX >= startCol && coordX <= endCol; coordX += deltaX) {
                        out(coordY, coordX);
                    }
                    if (location == 'u')
                        startRow++;
                    else
                        endRow--;
                } // иначе по вертикали
                else {
                    int coordX = location  == 'l' ? startCol : endCol;
                    int beginY = direction == '+' ? startRow : endRow;
                    int deltaY = direction == '+' ? +1 : -1;
                    for (int coordY = beginY; coordY >= startRow && coordY <= endRow; coordY += deltaY) {
                        out(coordY, coordX);
                    }
                    if (location == 'l')
                        startCol++;
                    else
                        endCol--;
                }

                if ((startRow > endRow) || (startCol > endCol))
                    return;
            }
        }
    }
}