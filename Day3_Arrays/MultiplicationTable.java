package Day3_Arrays;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] results = new int[4];

        for (int i = 0; i < 4; i++) {
            results[i] = number * (6 + i);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(number + " * " + (6 + i) + " = " + results[i]);
        }
    }
}