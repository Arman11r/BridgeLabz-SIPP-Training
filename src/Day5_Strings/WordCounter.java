package Day5_Strings;

import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] words = line.trim().split(" ");
        System.out.println("Word Count: " + words.length);
    }
}
