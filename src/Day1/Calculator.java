package Day1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double number1, number2;

        System.out.print("Enter the first number: ");
        number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        number2 = input.nextDouble();

        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 +
                " is " + addition + ", " + subtraction + ", " + multiplication + " and " + division);

        input.close();
    }
}
