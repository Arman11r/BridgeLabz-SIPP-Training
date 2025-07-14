package Day4StringBuilderLinearAndBinarySearch;

import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("sample.txt"), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}