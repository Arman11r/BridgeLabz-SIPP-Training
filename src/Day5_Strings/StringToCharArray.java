package Day5_Strings;

import java.util.*;

public class StringToCharArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            System.out.println(c);
        }
    }
}
