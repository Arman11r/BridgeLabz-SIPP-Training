package Day5AlgorithmRunTimeAnalysis;

import java.util.*;

public class DataStructureSearchComparision {

    public static void testSearchPerformance(int size, int target) {
        Random rand = new Random();
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int val = rand.nextInt(size * 2);
            array[i] = val;
            hashSet.add(val);
            treeSet.add(val);
        }

        long startArray = System.nanoTime();
        for (int val : array) {
            if (val == target) break;
        }
        long endArray = System.nanoTime();

        long startHash = System.nanoTime();
        hashSet.contains(target);
        long endHash = System.nanoTime();

        long startTree = System.nanoTime();
        treeSet.contains(target);
        long endTree = System.nanoTime();

        System.out.printf("Dataset Size: %,d\n", size);
        System.out.printf("Array Search Time: %.4f ms\n", (endArray - startArray) / 1e6);
        System.out.printf("HashSet Search Time: %.4f ms\n", (endHash - startHash) / 1e6);
        System.out.printf("TreeSet Search Time: %.4f ms\n", (endTree - startTree) / 1e6);
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("📦 Data Structure Search Performance Comparison");
        int target = -1;
        testSearchPerformance(1_000, target);
        testSearchPerformance(100_000, target);
        testSearchPerformance(1_000_000, target);
    }
}