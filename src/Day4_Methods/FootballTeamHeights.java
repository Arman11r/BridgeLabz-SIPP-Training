package Day4_Methods;
import java.util.*;

public class FootballTeamHeights {

    public static void main(String[] args) {
        int[] heights = generateHeights(11);          System.out.println("Player Heights (in cm): " + Arrays.toString(heights));

        int sum = getSum(heights);
        double mean = getMean(heights);
        int shortest = getShortest(heights);
        int tallest = getTallest(heights);

        System.out.println("Total Height: " + sum + " cm");
        System.out.println("Mean Height: " + mean + " cm");
        System.out.println("Shortest Player: " + shortest + " cm");
        System.out.println("Tallest Player: " + tallest + " cm");
    }

    public static int[] generateHeights(int size) {
        Random rand = new Random();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(101) + 150;
        }
        return heights;
    }

    
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int height : arr) {
            sum += height;
        }
        return sum;
    }


    public static double getMean(int[] arr) {
        return getSum(arr) / (double) arr.length;
    }


    public static int getShortest(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int height : arr) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }


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