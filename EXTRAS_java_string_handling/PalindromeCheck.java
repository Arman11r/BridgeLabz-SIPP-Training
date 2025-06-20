package EXTRAS_java_string_handling;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--)
            reversed += str.charAt(i);

        System.out.println(str.equalsIgnoreCase(reversed) ? "Palindrome" : "Not a palindrome");
        sc.close();
    }
}