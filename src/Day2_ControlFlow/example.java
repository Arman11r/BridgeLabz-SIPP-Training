package Day2_ControlFlow;

public class example {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        // Example of if-else statement
        if (a > b) {
            System.out.println("a is greater than b");
        } else {
            System.out.println("a is not greater than b");
        }

        // Example of switch-case statement
        int choice = 2; // Let's say we want to check for case 2
        switch (choice) {
            case 1:
                System.out.println("You chose option 1");
                break;
            case 2:
                System.out.println("You chose option 2");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
}
