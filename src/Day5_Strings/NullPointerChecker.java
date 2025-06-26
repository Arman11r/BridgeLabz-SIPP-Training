package Day5_Strings;

import java.util.*;

public class NullPointerChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;

        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException ");
        }
    }
}