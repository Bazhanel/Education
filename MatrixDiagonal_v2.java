import java.util.*;

public class MatrixDiagonal_v2 {

    public static void out(int cY, int cX) {
        System.out.println("[" + cY + "_" + cX + "]");
    }

    public static void main(String[] args) {
        int rowCount = 8;
        int colCount = 6;

        int[][] matrix = {
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6}
        };
        //colCount=matrix[0].length;
        //rowCount=matrix.length+1;
// произвольное диагональное движение
      /*  for (int S = 0; S < rowCount + colCount - 1; S++) {// лев. верх прав. низ
            //for (int S = 0; S < r + c -1 ; S++) {}// прав. низ лев. верх
            //for (int coordY = 0; coordY < rowCount; coordY++) { //движение в низ
                for (int coordY = rowCount-1; coordY >=0 ; coordY--) {//движение в верх
                int coordX = S - coordY;
                if (coordX >= colCount || coordX<0) continue;
                    System.out.println( matrix[coordX][coordY]);
            }

        }*/

        //Движение змейкой
        for (int s = 0; s < rowCount + colCount - 1; s++) {
            int startY, finishY, deltaY;
            if (s % 2 == 0) {
                startY = rowCount - 1;
                finishY = 0;
                deltaY = -1;
            } else {
                startY = 0;
                finishY = rowCount - 1;
                deltaY = 1;
            }
            for (int coordY = startY; coordY >= 0 && coordY < rowCount; coordY += deltaY) {//движение в верх
                int coordX = s - coordY;
                if (coordX >= colCount || coordX < 0) continue;
                //out(coordY, coordX);
                System.out.print(matrix[coordY][coordX]);
            }
            System.out.println();
        }

    }
}

