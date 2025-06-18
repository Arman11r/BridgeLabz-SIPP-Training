package Day5_Strings;

import java.util.*;

public class SplitFunction {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.split(" ");

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length()) shortest = word;
            if (word.length() > longest.length()) longest = word;
        }

        System.out.println("Shortest: " + shortest);
        System.out.println("Longest: " + longest);
    }
}
