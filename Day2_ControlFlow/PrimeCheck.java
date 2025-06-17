package Day2_ControlFlow;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        boolean isPrime = true;

        if (number <= 1) isPrime = false;
        else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) System.out.println(number + " is a Prime Number.");
        else System.out.println(number + " is NOT a Prime Number.");
    }
}