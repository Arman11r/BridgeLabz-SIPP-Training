package Day2_ControlFlow;
import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int service = sc.nextInt();

        if (service > 5) {
            double bonus = salary * 0.05;
            System.out.println("Bonus is: " + bonus);
        } else {
            System.out.println("No bonus.");
        }
    }
}