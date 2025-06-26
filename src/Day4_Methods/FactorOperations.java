package Day4_Methods;
import java.util.*;

public class FactorOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] factors = findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));

        int sum = sumOfFactors(factors);
        int product = productOfFactors(factors);
        int sumSquares = sumOfSquares(factors);

        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumSquares);
    }

    public static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int sumOfFactors(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }

    public static int productOfFactors(int[] arr) {
        int product = 1;
        for (int i : arr) product *= i;
        return product;
    }

    public static int sumOfSquares(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += Math.pow(i, 2);
        return sum;
    }
}