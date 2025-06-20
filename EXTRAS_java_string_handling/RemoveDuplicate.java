package EXTRAS_java_string_handling;

import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();
        String result = "";

        for (char c : input.toCharArray())
            if (result.indexOf(c) == -1)
                result += c;

        System.out.println("String without duplicates: " + result);
        sc.close();
    }
}