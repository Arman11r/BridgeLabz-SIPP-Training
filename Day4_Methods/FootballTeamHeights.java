package Day4_Methods;
import java.util.*;

public class FootballTeamHeights {

    public static void main(String[] args) {
        int[] heights = generateHeights(11);  // 11 players
        System.out.println("Player Heights (in cm): " + Arrays.toString(heights));

        int sum = getSum(heights);
        double mean = getMean(heights);
        int shortest = getShortest(heights);
        int tallest = getTallest(heights);

        System.out.println("Total Height: " + sum + " cm");
        System.out.println("Mean Height: " + mean + " cm");
        System.out.println("Shortest Player: " + shortest + " cm");
        System.out.println("Tallest Player: " + tallest + " cm");
    }

    // 1. Generate 11 random heights between 150 and 250 cm
    public static int[] generateHeights(int size) {
        Random rand = new Random();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(101) + 150; // (0 to 100) + 150 = 150 to 250
        }
        return heights;
    }

    // 2. Method to calculate the sum of all elements
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int height : arr) {
            sum += height;
        }
        return sum;
    }

    // 3. Method to calculate mean
    public static double getMean(int[] arr) {
        return getSum(arr) / (double) arr.length;
    }

    // 4. Method to find shortest height
    public static int getShortest(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int height : arr) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }

    // 5. Method to find tallest height
    public static int getTallest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int height : arr) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }
}