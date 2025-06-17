package Day3_Arrays;

import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            salaries[i] = sc.nextDouble();

            System.out.print("Enter years of service: ");
            years[i] = sc.nextDouble();

            if (salaries[i] <= 0 || years[i] < 0) {
                System.out.println("Invalid input. Re-enter data.");
                i--;
                continue;
            }

            if (years[i] > 5) {
                bonus[i] = salaries[i] * 0.05;
            } else {
                bonus[i] = salaries[i] * 0.02;
            }

            newSalaries[i] = salaries[i] + bonus[i];
            totalBonus += bonus[i];
            totalOld += salaries[i];
            totalNew += newSalaries[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
    }
}