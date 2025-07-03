package oopsjava.day6EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 2000;
    }

    public String getInsuranceDetails() {
        return "Car Insurance ₹2000";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance ₹500";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000;
    }

    public double calculateInsurance() {
        return 5000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance ₹5000";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car("CAR123", "Car", 1500));
        vehicleList.add(new Bike("BIKE456", "Bike", 500));
        vehicleList.add(new Truck("TRUCK789", "Truck", 3000));

        for (Vehicle v : vehicleList) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Rental Cost for 3 days: ₹" + v.calculateRentalCost(3));
            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                System.out.println("Insurance: ₹" + i.calculateInsurance());
                System.out.println(i.getInsuranceDetails());
            }
            System.out.println("--------------------------");
        }
    }
}
