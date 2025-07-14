package Day5AlgorithmRunTimeAnalysis;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformaceAnalysis {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;
        return i + 1;
    }

    public static void testSorting(int size) {
        Random rand = new Random();
        int[] baseData = new int[size];
        for (int i = 0; i < size; i++) {
            baseData[i] = rand.nextInt(size * 2);
        }

        int[] bubble = Arrays.copyOf(baseData, size);
        int[] merge = Arrays.copyOf(baseData, size);
        int[] quick = Arrays.copyOf(baseData, size);

        long startBubble = System.nanoTime();
        if (size <= 10000) bubbleSort(bubble);
        long endBubble = System.nanoTime();
        long timeBubble = (size <= 10000) ? endBubble - startBubble : -1;

        long startMerge = System.nanoTime();
        mergeSort(merge);
        long endMerge = System.nanoTime();
        long timeMerge = endMerge - startMerge;

        long startQuick = System.nanoTime();
        quickSort(quick, 0, quick.length - 1);
        long endQuick = System.nanoTime();
        long timeQuick = endQuick - startQuick;

        System.out.printf("Dataset Size: %,d\n", size);
        if (timeBubble == -1)
            System.out.println("Bubble Sort: Unfeasible");
        else
            System.out.printf("Bubble Sort Time: %.2f ms\n", timeBubble / 1e6);

        System.out.printf("Merge Sort Time: %.2f ms\n", timeMerge / 1e6);
        System.out.printf("Quick Sort Time: %.2f ms\n", timeQuick / 1e6);
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println(" Sorting Algorithm Performance Comparison");
        testSorting(1000);
        testSorting(10_000);
        testSorting(1_000_000);
    }
}