package Day4StringBuilderLinearAndBinarySearch;

public class WordInSentances {
    public static String searchWord(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word)) return s;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"I love Java", "Programming is fun", "Hello world"};
        System.out.println(searchWord(sentences, "Java")); // Output: I love Java
    }
}