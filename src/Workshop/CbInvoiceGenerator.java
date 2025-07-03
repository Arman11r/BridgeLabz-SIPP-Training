package Workshop;

import java.util.*;


class Ride {
    double distance;
    double time;

    Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }
}

class RideRepository {
    List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> getAllRides() {
        return rides;
    }
}

public class CbInvoiceGenerator {
    static final double MINIMUM_FARE = 5.0;
    static final double MINIMUM_FARE_PREM = 20.0;
    static final double COST_PER_KM = 10.0;
    static final double COST_PER_KM_PREM = 15.0;
    static final double COST_PER_MIN = 1.0;
    static final double COST_PER_MIN_PREM = 2.0;

    public static int callnorm(double distance, double time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return (int) Math.max(fare, MINIMUM_FARE);
    }
    public static int callprem(double distance, double time) {
        double fare = distance * COST_PER_KM_PREM + time * COST_PER_MIN_PREM;
        return (int) Math.max(fare, MINIMUM_FARE_PREM);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RideRepository rideRepo = new RideRepository();
        String type = "";
        
        
        System.out.print("Enter UserId : ");
        String user = sc.nextLine();
        
        while (true) {
            System.out.print("What type of Ride 'Normal Or Premium' ? : ");
            type = sc.nextLine();

            if (type.equalsIgnoreCase("Normal") || type.equalsIgnoreCase("Premium")) {
                break; // valid input
            } else {
                System.out.println("Invalid input. Please enter 'Normal' or 'Premium'.");
            }
        }

        

        System.out.print("How many rides? for "+user+": ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Distance (KM) for ride " + (i + 1) + ": ");
            double dis = sc.nextDouble();
            System.out.print("Enter Time (in min) for ride " + (i + 1) + ": ");
            double time = sc.nextDouble();

            Ride ride = new Ride(dis, time);
            rideRepo.addRide(ride);
        }

        int totalFare = 0;
        List<Ride> allRides = rideRepo.getAllRides();
        if (type.equalsIgnoreCase("Normal")) {
            for (Ride ride : allRides) {
                totalFare += callnorm(ride.distance, ride.time);
            }
        } else if (type.equalsIgnoreCase("Premium")) {
            for (Ride ride : allRides) {
                totalFare += callprem(ride.distance, ride.time);
            }
        } else {
            System.out.println("Invalid Ride Type Input");
            return; 
        }

        double avgFare = (n > 0) ? (double) totalFare / n : 0;

        System.out.println("=====================================");
        System.out.println("|| USerID : "+user);
        System.out.println("|| Ride Type : " +type);
        System.out.println("|| Total number of rides: " + n);
        System.out.println("|| Total fare: " + totalFare);
        System.out.println("|| Average fare per ride: " + avgFare);
        System.out.println("=====================================");
    }
}
