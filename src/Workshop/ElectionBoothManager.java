package Workshop;

import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] votes = new int[3];
        String choice;

        while (true) {
            System.out.print("Enter your age (or type 'exit' to stop): ");
            choice = sc.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            int age = Integer.parseInt(choice);
            if (age < 18) {
                System.out.println("You are not eligible to vote.");
                continue;
            }

            System.out.print("Vote for Candidate (1, 2, or 3): ");
            int vote = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (vote >= 1 && vote <= 3) {
                votes[vote - 1]++;
                System.out.println("Vote recorded!");
            } else {
                System.out.println("Invalid candidate number.");
            }
        }

        System.out.println("\n📊 Voting Results:");
        for (int i = 0; i < votes.length; i++) {
            System.out.println("Candidate " + (i + 1) + ": " + votes[i] + " votes");
        }

        sc.close();
    }
}