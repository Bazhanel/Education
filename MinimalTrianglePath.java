import  java.util.*;

public class MinimalTrianglePath {
  public static int N;
  public static int[][] triangleM;
  public static int minSum = 1; // для формирование первичного явно НЕ оптимального решения. Чтоб можно было улучшать поиск

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    triangleM = new int[N][N];

    for (int i = 0; i < N; i++) { // i - кордината "у", номер строки
      for (int j = 0; j < i + 1; j++) {// j -  кордината х, номер колонки. От 0 до значения номера строки
        triangleM[i][j] = in.nextInt();
        minSum += triangleM[i][j]; // формирование первичного явно НЕ оптимального решения
      }
    }
    //
    findMinimalPath(triangleM[0][0], 0, 0); // запуск поиска из ячейки с кооридинатами (0,0)
    System.out.print(minSum);
  }

  // countSteps = coordY +1 //findMinimalPath(int countSteps, int currentSum, int coordY, int coordX)
  public static void findMinimalPath(int currentSum, int coordY, int coordX) {

    // если в какой то клетке накопленная сумма привышает оптимальное решение, то дальше запускать рекурсивный поиск нет смысла
    if (currentSum > minSum)
      return;

    if (coordY == N - 1) { // точка выхода из рекурсии: прошли N  шагов

      if (currentSum < minSum) { // текущая накопленная сумма меньше ранее найденого оптимального решения
        minSum = currentSum; // улучшаем оптимальное решение
      }
      return; // выходим из рекурсии по условию
    }
    // 1 - движение вертекально в низ;
    findMinimalPath(currentSum + triangleM[coordY + 1][coordX + 0], coordY + 1, coordX + 0);
    // 2 - движение в низ и в право;
    findMinimalPath(currentSum + triangleM[coordY + 1][coordX + 1], coordY + 1, coordX + 1);
  }
}