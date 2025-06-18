package Day4_Methods;
import java.util.*;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int count = countDigits(number);
        int[] digits = getDigitsArray(number, count);

        System.out.println("Count of digits: " + count);
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(digits, number));

        int[] largestTwo = findLargestTwo(digits);
        System.out.println("Largest: " + largestTwo[0] + ", Second Largest: " + largestTwo[1]);

        int[] smallestTwo = findSmallestTwo(digits);
        System.out.println("Smallest: " + smallestTwo[0] + ", Second Smallest: " + smallestTwo[1]);
    }

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number, int count) {
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits, int number) {
        int power = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    public static int[] findLargestTwo(int[] digits) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max) {
                secondMax = max;
                max = d;
            } else if (d > secondMax && d != max) {
                secondMax = d;
            }
        }
        return new int[]{max, secondMax};
    }

    public static int[] findSmallestTwo(int[] digits) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min) {
                secondMin = min;
                min = d;
            } else if (d < secondMin && d != min) {
                secondMin = d;
            }
        }
        return new int[]{min, secondMin};
    }
}