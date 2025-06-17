package Day3_Arrays;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // weight, height, bmi
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            double weight = sc.nextDouble();

            System.out.print("Enter height (m): ");
            double height = sc.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            double bmi = weight / (height * height);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi < 18.5) weightStatus[i] = "Underweight";
            else if (bmi < 24.9) weightStatus[i] = "Normal";
            else if (bmi < 29.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("Weight\tHeight\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}