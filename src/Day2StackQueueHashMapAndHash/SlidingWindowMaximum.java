package Day2StackQueueHashMapAndHash;
import java.util.*;

public class SlidingWindowMaximum {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of window
            while (!dq.isEmpty() && dq.peek() <= i - k)
                dq.poll();

            // Remove smaller values as they're not needed
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offer(i);
            if (i >= k - 1)
                res.add(nums[dq.peek()]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k)); // Output: [3, 3, 5, 5, 6, 7]
    }
}