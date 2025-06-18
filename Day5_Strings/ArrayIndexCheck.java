package Day5_Strings;

import java.util.*;

public class ArrayIndexCheck {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();

        try {
            System.out.println("Element at index " + index + " is " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index: " + e.getMessage());
        }
    }
}
