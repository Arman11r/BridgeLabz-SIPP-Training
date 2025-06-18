package Day4_Methods;

import java.util.*;

public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] result = new double[3];
        result[0] = Math.sin(radians);
        result[1] = Math.cos(radians);
        result[2] = Math.tan(radians);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double angle = sc.nextDouble();
        double[] functions = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine: %.4f\nCosine: %.4f\nTangent: %.4f\n", functions[0], functions[1], functions[2]);
    }
}
