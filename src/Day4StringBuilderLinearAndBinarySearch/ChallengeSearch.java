package Day4StringBuilderLinearAndBinarySearch;

import java.util.Arrays;

public class ChallengeSearch {
    public static int findFirstMissingPositive(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) seen[num] = true;
        }

        for (int i = 1; i < seen.length; i++) {
            if (!seen[i]) return i;
        }
        return nums.length + 1;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums));

        Arrays.sort(nums); // Needed before binary search
        System.out.println("Index of 4: " + binarySearch(nums, 4));
    }
}