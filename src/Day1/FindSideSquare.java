package Day1;

import java.util.Scanner;

public class FindSideSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double perimeter;

        System.out.print("Enter the perimeter of the square: ");
        perimeter = input.nextDouble();

        double side = perimeter / 4;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        input.close();
    }
}
