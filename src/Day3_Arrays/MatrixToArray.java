package Day3_Arrays;

import java.util.Scanner;

public class MatrixToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] flatArray = new int[rows * cols];

        System.out.println("Enter matrix values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int index = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                flatArray[index++] = val;
            }
        }

        System.out.print("Flattened Array: ");
        for (int value : flatArray) {
            System.out.print(value + " ");
        }
    }
}