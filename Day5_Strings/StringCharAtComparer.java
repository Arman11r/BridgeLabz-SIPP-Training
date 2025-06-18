package Day5_Strings;
import java.util.*;

public class StringCharAtComparer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        boolean manualCompare = compareUsingCharAt(s1, s2);
        boolean builtInCompare = s1.equals(s2);

        System.out.println("Manual charAt comparison: " + manualCompare);
        System.out.println("Built-in equals comparison: " + builtInCompare);

        if (manualCompare == builtInCompare) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Results differ between methods.");
        }
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}