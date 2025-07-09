package Day2StackQueueHashMapAndHash;
import java.util.Stack;

public class SortStackRecurive {
    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sort(stack);
            insertSorted(stack, top);
        }
    }

    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertSorted(stack, element);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(2);

        sort(s);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}