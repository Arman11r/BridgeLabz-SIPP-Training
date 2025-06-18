package Day5_Strings;

import java.util.*;

public class StringComparer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (s1.equals(s2)) {
            System.out.println("Strings are equal" );
        } else {
            System.out.println("Strings are not equal ");
        }
    }
}