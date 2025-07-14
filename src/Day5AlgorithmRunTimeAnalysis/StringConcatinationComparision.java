package Day5AlgorithmRunTimeAnalysis;

public class StringConcatinationComparision {

    public static void testConcatenation(int n) {
        long start, end;

        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a";
        }
        end = System.nanoTime();
        double stringTime = (end - start) / 1e6;

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        double builderTime = (end - start) / 1e6;

        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }
        end = System.nanoTime();
        double bufferTime = (end - start) / 1e6;

        System.out.printf("Operations Count: %,d\n", n);
        System.out.printf("String Time: %.2f ms\n", stringTime);
        System.out.printf("StringBuilder Time: %.2f ms\n", builderTime);
        System.out.printf("StringBuffer Time: %.2f ms\n", bufferTime);
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("🔠 String Concatenation Performance Comparison");
        testConcatenation(1000);
        testConcatenation(10_000);
        testConcatenation(1_000_000);
    }
}