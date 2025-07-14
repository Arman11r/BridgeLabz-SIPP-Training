package Day4StringBuilderLinearAndBinarySearch;

public class FirstNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, -1, 5};
        System.out.println("Index: " + findFirstNegative(nums)); // Output: 3
    }
}