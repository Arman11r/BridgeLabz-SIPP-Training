package Day4StringBuilderLinearAndBinarySearch;

public class RotationPoint {
    public static int findRotationIndex(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 2, 3};
        System.out.println("Rotation Index: " + findRotationIndex(nums)); // Output: 3
    }
}