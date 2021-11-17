public class Matrix {
    public static void rotateMatrix(int[][] matrix) {
        int row = matrix.length;
        // первый ряд - первый столбец, второй ряд - второй столбец, ...
        for (int i = 0; i < row; i++) {
            for (int j = i; j < row; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // первый стобец - последний, второй - предпоследний, ... (по рядам: меняю местами первое и последнее число, второе и предпоследнее, ...)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - 1 - j];
                matrix[i][row - 1 - j] = temp;
            }
        }
    }

    // распечатываю уже перевёрнутую матрицу
    public static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
