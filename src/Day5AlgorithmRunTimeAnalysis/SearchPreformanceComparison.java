package Day5AlgorithmRunTimeAnalysis;

import java.util.Arrays;
import java.util.Random;

public class SearchPreformanceComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        return Arrays.binarySearch(arr, target);
    }

    public static void testPerformance(int size, int target) {
        Random rand = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 2);
        }

        long startLinear = System.nanoTime();
        linearSearch(data, target);
        long endLinear = System.nanoTime();
        long durationLinear = endLinear - startLinear;

        Arrays.sort(data);
        long startBinary = System.nanoTime();
        binarySearch(data, target);
        long endBinary = System.nanoTime();
        long durationBinary = endBinary - startBinary;

        System.out.printf("Dataset Size: %,d\n", size);
        System.out.printf("Linear Search Time: %.5f ms\n", durationLinear / 1e6);
        System.out.printf("Binary Search Time (including sort): %.5f ms\n", durationBinary / 1e6);
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("🔍 Search Performance Comparison");
        int target = -1;
        testPerformance(1000, target);
        testPerformance(10_000, target);
        testPerformance(1_000_000, target);
    }
}