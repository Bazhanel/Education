import java.util.*;

public class MatrixSnakeMove {

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
        //Движение змейкой
        for (int s = 0; s < rowCount + colCount - 1; s++) {
            boolean isEven = s % 2 == 0; //для смены движения меняем 0 на 1
               int startY =  isEven ? rowCount - 1: 0;
               int deltaY = isEven ? -1: 1;

            for (int coordY = startY; coordY >= 0 && coordY < rowCount; coordY += deltaY) {//движение в верх
                int coordX = s - coordY;
                if (coordX >= colCount || coordX < 0)
                    continue;
                System.out.print(matrix[coordY][coordX]);
            }
            System.out.println();
        }

    }
}

