package oopsjava.day1javaclassandmethods;

public class PalindromeChecker {
    String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is Palindrome?  " + isPalindrome());
    }
}