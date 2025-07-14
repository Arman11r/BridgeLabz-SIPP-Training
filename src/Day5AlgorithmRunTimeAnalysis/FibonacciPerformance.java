package Day5AlgorithmRunTimeAnalysis;

public class FibonacciPerformance {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void testFibonacci(int n) {
        long start, end;

        start = System.nanoTime();
        if (n <= 40) fibonacciRecursive(n); // Avoid >40 due to exponential time
        end = System.nanoTime();
        double recursiveTime = (n <= 40) ? (end - start) / 1e6 : -1;

        start = System.nanoTime();
        fibonacciIterative(n);
        end = System.nanoTime();
        double iterativeTime = (end - start) / 1e6;

        System.out.printf("Fibonacci N = %d\n", n);
        if (recursiveTime == -1)
            System.out.println("Recursive Time: Unfeasible (>1hr estimated)");
        else
            System.out.printf("Recursive Time: %.4f ms\n", recursiveTime);

        System.out.printf("Iterative Time: %.4f ms\n", iterativeTime);
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("🔢 Fibonacci Recursive vs Iterative Performance Comparison");
        testFibonacci(10);
        testFibonacci(30);
        testFibonacci(50);
    }
}