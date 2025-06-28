package Workshop;

import java.util.Scanner;

public class ParkingLotGateSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = 5; 
        int occupied = 0;
        int choice;

        while (true) {
            System.out.println("\n🚗 Parking Lot Menu:");
            System.out.println("1. Park");
            System.out.println("2. Exit Lot");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (occupied < capacity) {
                        occupied++;
                        System.out.println("Car parked. Slots left: " + (capacity - occupied));
                    } else {
                        System.out.println("Parking lot full!");
                    }
                    break;

                case 2:
                    if (occupied > 0) {
                        occupied--;
                        System.out.println("Car exited. Slots available: " + (capacity - occupied));
                    } else {
                        System.out.println("No cars in the lot.");
                    }
                    break;

                case 3:
                    System.out.println("Current Occupancy: " + occupied + "/" + capacity);
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}