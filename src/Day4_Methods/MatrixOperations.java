package Day4_Methods;
import java.util.*;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = generateMatrix(3, 3);
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] transpose = transpose(matrix);
        System.out.println("Transpose Matrix:");
        printMatrix(transpose);

        int det = determinant3x3(matrix);
        System.out.println("Determinant of 3x3 Matrix: " + det);

        if (det != 0) {
            double[][] inverse = inverse3x3(matrix);
            System.out.println("Inverse of 3x3 Matrix:");
            printMatrix(inverse);
        } else {
            System.out.println("Matrix is not invertible (det = 0)");
        }
    }

    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = rand.nextInt(10); // values between 0-9
        return mat;
    }

    public static int[][] transpose(int[][] mat) {
        int[][] result = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                result[j][i] = mat[i][j];
        return result;
    }

    public static int determinant2x2(int[][] mat) {
        return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
    }

    public static int determinant3x3(int[][] m) {
        int det = m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1]) -
                  m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0]) +
                  m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        return det;
    }

    public static double[][] inverse2x2(int[][] mat) {
        int det = determinant2x2(mat);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = mat[1][1] / (double) det;
        inv[0][1] = -mat[0][1] / (double) det;
        inv[1][0] = -mat[1][0] / (double) det;
        inv[1][1] = mat[0][0] / (double) det;
        return inv;
    }

    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        double[][] inv = new double[3][3];

        inv[0][0] = ((m[1][1]*m[2][2] - m[1][2]*m[2][1]) / (double) det);
        inv[0][1] = -((m[0][1]*m[2][2] - m[0][2]*m[2][1]) / (double) det);
        inv[0][2] = ((m[0][1]*m[1][2] - m[0][2]*m[1][1]) / (double) det);

        inv[1][0] = -((m[1][0]*m[2][2] - m[1][2]*m[2][0]) / (double) det);
        inv[1][1] = ((m[0][0]*m[2][2] - m[0][2]*m[2][0]) / (double) det);
        inv[1][2] = -((m[0][0]*m[1][2] - m[0][2]*m[1][0]) / (double) det);

        inv[2][0] = ((m[1][0]*m[2][1] - m[1][1]*m[2][0]) / (double) det);
        inv[2][1] = -((m[0][0]*m[2][1] - m[0][1]*m[2][0]) / (double) det);
        inv[2][2] = ((m[0][0]*m[1][1] - m[0][1]*m[1][0]) / (double) det);

        return inv;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void printMatrix(double[][] mat) {
        for (double[] row : mat) {
            for (double val : row)
                System.out.printf("%.2f ", val);
            System.out.println();
        }
    }
}