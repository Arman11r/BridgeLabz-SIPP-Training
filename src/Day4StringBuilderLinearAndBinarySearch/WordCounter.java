package Day4StringBuilderLinearAndBinarySearch;

import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        String target = "java";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    if (word.equalsIgnoreCase(target)) count++;
                }
            }
            System.out.println("Occurrences of '" + target + "': " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}