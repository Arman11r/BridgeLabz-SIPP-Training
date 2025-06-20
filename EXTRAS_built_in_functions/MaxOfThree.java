package EXTRAS_built_in_functions;

import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = getInput(sc, "Enter first number: ");
        int b = getInput(sc, "Enter second number: ");
        int c = getInput(sc, "Enter third number: ");
        int max = findMax(a, b, c);
        System.out.println("Maximum number is: " + max);
        sc.close();
    }

    public static int getInput(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    public static int findMax(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}