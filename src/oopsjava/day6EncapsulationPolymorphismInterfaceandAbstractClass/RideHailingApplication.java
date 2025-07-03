package oopsjava.day6EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.*;

abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: ₹" + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class CarRide extends RideVehicle implements GPS {
    private String currentLocation;

    public CarRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class BikeRide extends RideVehicle implements GPS {
    private String currentLocation;

    public BikeRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class AutoRide extends RideVehicle implements GPS {
    private String currentLocation;

    public AutoRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        List<RideVehicle> rides = new ArrayList<>();

        CarRide car = new CarRide("C123", "Arman", 15);
        BikeRide bike = new BikeRide("B456", "Riya", 8);
        AutoRide auto = new AutoRide("A789", "Kartikey", 10);

        car.updateLocation("Sector 5");
        bike.updateLocation("Sector 9");
        auto.updateLocation("Sector 2");

        rides.add(car);
        rides.add(bike);
        rides.add(auto);

        for (RideVehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Fare for 10km: ₹" + v.calculateFare(10));
            if (v instanceof GPS) {
                System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            }
            System.out.println("---------------------------");
        }
    }
}