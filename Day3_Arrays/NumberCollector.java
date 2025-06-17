package Day3_Arrays;

import java.util.Scanner;

public class NumberCollector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            if (index == 10) break;

            System.out.print("Enter a number: ");
            double input = sc.nextDouble();

            if (input <= 0) break;

            numbers[index++] = input;
        }

        System.out.print("Entered numbers: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        System.out.println("\nTotal = " + total);
    }
}