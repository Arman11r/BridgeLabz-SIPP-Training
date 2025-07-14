package Day3SortingAlgorithms;

import java.util.*;

public class SelectionSortExamScores {
    public static void main(String[] args) {
        int[] scores = {68, 75, 60, 89, 70};

        for (int i = 0; i < scores.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[minIdx];
            scores[minIdx] = temp;
        }

        System.out.println("Sorted Exam Scores: " + Arrays.toString(scores));
    }
}