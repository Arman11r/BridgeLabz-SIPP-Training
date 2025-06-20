package EXTRAS_java_string_handling;

import java.util.Scanner;

public class LexicoGraphicCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        int result = 0, len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result = str1.charAt(i) - str2.charAt(i);
                break;
            }
        }

        if (result == 0) result = str1.length() - str2.length();

        if (result < 0)
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\"");
        else if (result > 0)
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\"");
        else
            System.out.println("Strings are equal");
        
        sc.close();
    }
}