package Day4_Methods;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            double weight = sc.nextDouble();
            double height = sc.nextDouble();
            data[i][0] = weight;
            data[i][1] = height;
        }

        calculateBMI(data);
        calculateStatus(data, status);

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + data[i][0] + " kg");
            System.out.println("Height: " + data[i][1] + " cm");
            System.out.println("BMI: " + data[i][2]);
            System.out.println("Status: " + status[i]);
            System.out.println();
        }
    }

    public static void calculateBMI(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            double weight = arr[i][0];
            double heightInMeters = arr[i][1] / 100.0;
            double bmi = weight / (heightInMeters * heightInMeters);
            arr[i][2] = bmi;
        }
    }

    public static void calculateStatus(double[][] arr, String[] status) {
        for (int i = 0; i < arr.length; i++) {
            double bmi = arr[i][2];
            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
    }
}