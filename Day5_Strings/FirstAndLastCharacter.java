package Day5_Strings;

import java.util.*;

public class FirstAndLastCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (!input.isEmpty()) {
            System.out.println("First: " + input.charAt(0));
            System.out.println("Last: " + input.charAt(input.length() - 1));
        }
    }
}
