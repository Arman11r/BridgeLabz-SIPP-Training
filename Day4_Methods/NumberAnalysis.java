package Day4_Methods;
import java.util.*;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if (isPositive(arr[i])) {
                System.out.println(arr[i] + " is Positive and " + (isEven(arr[i]) ? "Even" : "Odd"));
            } else {
                System.out.println(arr[i] + " is Negative");
            }
        }

        int result = compare(arr[0], arr[4]);
        if (result == 0) {
            System.out.println("First and last elements are equal");
        } else if (result == 1) {
            System.out.println("First element is greater than last");
        } else {
            System.out.println("First element is less than last");
        }
    }

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }
}