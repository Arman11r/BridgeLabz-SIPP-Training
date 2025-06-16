package Day2;
import java.util.*;
public class SwitchCaseCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a  = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        int choice = sc.nextInt();

        
        double result;

        switch (choice) {
            case 1 -> {
                result = a + b;
                System.out.println("Result: " + result);
            }
            case 2 -> {
                result = a - b;
                System.out.println("Result: " + result);
            }
            case 3 -> {
                result = a * b;
                System.out.println("Result: " + result);
            }
            case 4 -> {
                if (b != 0) {
                    result = a/b;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
            }
            default -> System.out.println("Invalid choice! Please select a valid operation.");
        }
    }

    
}
