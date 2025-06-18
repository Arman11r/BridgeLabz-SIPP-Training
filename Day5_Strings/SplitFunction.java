package Day5_Strings;

import java.util.*;

public class SplitFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split("  ");

        for (String word : words) {
            System.out.println(word);
        }
    }
}