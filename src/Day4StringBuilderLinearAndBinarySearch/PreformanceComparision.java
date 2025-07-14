package Day4StringBuilderLinearAndBinarySearch;

public class PreformanceComparision {
    public static void main(String[] args) {
        int n = 1000000;

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("hello");
        long endBuffer = System.nanoTime();

        long startBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) sbd.append("hello");
        long endBuilder = System.nanoTime();

        System.out.println("StringBuffer time: " + (endBuffer - startBuffer) + " ns");
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) + " ns");
    }
}