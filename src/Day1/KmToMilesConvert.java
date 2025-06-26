package Day1;
import java.util.Scanner;
public class KmToMilesConvert {
    public static void main(String[] args) {
        double km;
        Scanner input = new Scanner(System.in); 

        System.out.print("Enter distance in kilometers: ");
        km = input.nextInt(); 

        double miles = km / 1.6;

        System.out.println("The total miles is " + miles);
        
        input.close(); 
    }
}
