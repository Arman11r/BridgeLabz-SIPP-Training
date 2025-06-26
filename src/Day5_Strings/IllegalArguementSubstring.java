package Day5_Strings;

import java.util.*;

public class IllegalArguementSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        try {
            System.out.println(str.substring(start, end));
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Exception: " + e);
        }
    }
}
