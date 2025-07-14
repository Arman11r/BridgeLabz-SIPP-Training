package Day4StringBuilderLinearAndBinarySearch;

import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("output.txt")) {
            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(input + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}