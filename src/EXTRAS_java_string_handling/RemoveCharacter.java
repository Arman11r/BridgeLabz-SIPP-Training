package EXTRAS_java_string_handling;

import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter character to remove: ");
        char ch = sc.next().charAt(0);

        String result = "";
        for (char c : str.toCharArray())
            if (c != ch)
                result += c;

        System.out.println("Modified String: " + result);
        sc.close();
    }
}