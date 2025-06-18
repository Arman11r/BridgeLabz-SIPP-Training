package Day5_Strings;

import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalGames = sc.nextInt();
        sc.nextLine();

        int wins = 0;
        for (int i = 0; i < totalGames; i++) {
            String user = sc.next().toLowerCase();
            String computer = sc.next().toLowerCase();
            if ((user.equals("rock") && computer.equals("scissors")) ||
                (user.equals("scissors") && computer.equals("paper")) ||
                (user.equals("paper") && computer.equals("rock"))) {
                wins++;
            }
        }
        double percentage = (wins * 100.0) / totalGames;
        System.out.printf("Win Percentage: %.2f%%\n", percentage);
    }
}
