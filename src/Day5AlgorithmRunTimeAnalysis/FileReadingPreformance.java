package Day5AlgorithmRunTimeAnalysis;

import java.io.*;

public class FileReadingPreformance {

    public static void testFileReading(String filePath) throws IOException {
        long start, end;

        start = System.nanoTime();
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1) {}
        fr.close();
        end = System.nanoTime();
        double fileReaderTime = (end - start) / 1e6;

        start = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1) {}
        isr.close();
        end = System.nanoTime();
        double inputStreamReaderTime = (end - start) / 1e6;

        System.out.println("📁 File: " + filePath);
        System.out.printf("FileReader Time: %.2f ms\n", fileReaderTime);
        System.out.printf("InputStreamReader Time: %.2f ms\n", inputStreamReaderTime);
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("📂 File Reading Performance Comparison");

        testFileReading("test1MB.txt");
        testFileReading("test100MB.txt");
        testFileReading("test500MB.txt");
    }
}