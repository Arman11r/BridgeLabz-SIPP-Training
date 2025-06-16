package Day1;
public class DistanceConvert {
    public static void main(String[] args) {
        double kilometers = 10.8;
        double conversionFactor = 1.6;

        double miles = kilometers * conversionFactor;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}
