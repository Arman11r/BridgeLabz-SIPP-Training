package Day2_ControlFlow;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();
        System.out.print("Enter height (cm): ");
        double height = sc.nextDouble();

        height /= 100; // Convert to meters
        double bmi = weight / (height * height);
        System.out.printf("BMI: %.2f\n", bmi);

        if (bmi < 18.5) System.out.println("Underweight");
        else if (bmi < 24.9) System.out.println("Normal");
        else if (bmi < 29.9) System.out.println("Overweight");
        else System.out.println("Obese");
    }
}