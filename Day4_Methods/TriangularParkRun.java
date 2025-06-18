package Day4_Methods;

import java.util.Scanner;

public class TriangularParkRun {
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distanceToRun = 5000;
        return distanceToRun / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        double rounds = calculateRounds(side1, side2, side3);
        System.out.printf("%.2f%n", rounds);
    }
}