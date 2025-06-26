package Day1;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double distanceInFeet;

        System.out.print("Enter the distance in feet: ");
        distanceInFeet = input.nextDouble();

        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;

        System.out.println("The distance is " + distanceInFeet + " feet, which is " + distanceInYards + " yards and " + distanceInMiles + " miles");

        input.close();
    }
}
 