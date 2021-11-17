public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Matrix.rotateMatrix(matrix);
        Matrix.rotateMatrix(matrix);
        Matrix.printMatrix(matrix);
    }
}
