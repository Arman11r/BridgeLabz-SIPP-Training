package Day3SortingAlgorithms;

import java.util.*;

public class CountingSortStudentAges {
    public static void main(String[] args) {
        int[] ages = {12, 15, 11, 14, 12, 10, 13, 12};

        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        for (int age : ages) {
            count[age - minAge]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                ages[index++] = i + minAge;
            }
        }

        System.out.println("Sorted Ages: " + Arrays.toString(ages));
    }
}