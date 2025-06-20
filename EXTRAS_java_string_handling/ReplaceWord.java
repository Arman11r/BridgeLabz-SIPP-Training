package EXTRAS_java_string_handling;

import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter the word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();

        String result = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified Sentence: " + result);
        sc.close();
    }

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }
}