package EXTRAS_java_string_handling;

import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine().toLowerCase();
        int[] freq = new int[256];

        for (char c : input.toCharArray())
            freq[c]++;

        int max = 0;
        char maxChar = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = (char) i;
            }
        }

        System.out.println("Most Frequent Character: '" + maxChar + "'");
        sc.close();
    }
}