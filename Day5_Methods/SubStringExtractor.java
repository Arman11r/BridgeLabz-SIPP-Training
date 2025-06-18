package Day5_Methods;

import java.util.*;

public class SubStringExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();

        try {
            String sub = str.substring(start, end);
            System.out.println("Substring: " + sub);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + e.getMessage());
        }
    }
}
