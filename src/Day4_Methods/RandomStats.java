package Day4_Methods;
import java.util.*;

public class RandomStats {
    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);
        double[] stats = findAverageMinMax(numbers);

        System.out.println("Generated 4-digit numbers: " + Arrays.toString(numbers));
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + stats[1]);
        System.out.println("Maximum: " + stats[2]);
    }

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double[] result = new double[3];
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        result[0] = (double) sum / numbers.length;
        result[1] = min;
        result[2] = max;
        return result;
    }
}