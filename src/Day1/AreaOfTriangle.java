package Day1;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double base, height;

        System.out.print("Enter the base of the triangle in inches: ");
        base = input.nextDouble();

        System.out.print("Enter the height of the triangle in inches: ");
        height = input.nextDouble();

        double areaInInches = 0.5 * base * height;
        double areaInCm = areaInInches * 6.4516;

        System.out.println("The area of the triangle is " + areaInInches + " square inches and " + areaInCm + " square centimeters");

        input.close();
    }
}
