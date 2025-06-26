package Day5_Strings;

import java.util.*;

public class VotingEligibility {
    public static void main(String[] args) {
        Random rand = new Random();
        int eligible = 0;
        for (int i = 0; i < 10; i++) {
            int age = rand.nextInt(41) + 10; // age between 10 and 50
            if (age >= 18) {
                eligible++;
                System.out.println("Person " + (i + 1) + " age: " + age + " is eligible to vote");
            } else {
                System.out.println("Person " + (i + 1) + " age: " + age + " is NOT eligible to vote");
            }
        }
        System.out.println("Total eligible voters: " + eligible);
    }
}