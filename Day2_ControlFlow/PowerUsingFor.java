package Day2_ControlFlow;

import java.util.Scanner;

public class PowerUsingFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int base = sc.nextInt();
        System.out.print("Enter power: ");
        int power = sc.nextInt();

        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= base;
        }
        System.out.println(base + " raised to " + power + " is: " + result);
    }
}