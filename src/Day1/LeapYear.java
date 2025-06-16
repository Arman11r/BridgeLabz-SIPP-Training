package Day1;
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year (>= 1582): ");
        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("The year is not valid. Gregorian calendar started in 1582.");
        } else {
    
            System.out.println("=== Using multiple if-else conditions ===");
            if (year % 4 != 0) {
                System.out.println(year + " is not a Leap Year.");
            } else if (year % 100 != 0) {
                System.out.println(year + " is a Leap Year.");
            } else if (year % 400 == 0) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }


            System.out.println("=== Using single if condition with logical expression ===");
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        }

    }
}