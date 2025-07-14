package Day3SortingAlgorithms;

import java.util.*;

public class MergeSortBookPrices {
    public static void main(String[] args) {
        int[] prices = {450, 250, 300, 150, 500};
        mergeSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Book Prices: " + Arrays.toString(prices));
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right)
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++)
            arr[left + x] = temp[x];
    }
}