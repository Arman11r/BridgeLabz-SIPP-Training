package Day4StringBuilderLinearAndBinarySearch;

public class FirstLastOccurance {
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 4, 6, 8};
        int[] range = searchRange(nums, 4);
        System.out.println("First: " + range[0] + ", Last: " + range[1]);
    }
}