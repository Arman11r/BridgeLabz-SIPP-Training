package EXTRAS_built_in_functions;

import java.util.Scanner;

public class TempratureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Convert (1) F to C or (2) C to F: ");
        int choice = sc.nextInt();
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        if (choice == 1) {
            System.out.println("Celsius: " + toCelsius(temp));
        } else {
            System.out.println("Fahrenheit: " + toFahrenheit(temp));
        }
        sc.close();
    }

    public static double toCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double toFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}