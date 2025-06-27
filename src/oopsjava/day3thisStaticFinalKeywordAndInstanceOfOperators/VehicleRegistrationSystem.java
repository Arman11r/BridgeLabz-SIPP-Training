package oopsjava.day3thisStaticFinalKeywordAndInstanceOfOperators;

class Vehicle {
    static double registrationFee = 1500.0;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name         : " + ownerName);
            System.out.println("Vehicle Type       : " + vehicleType);
            System.out.println("Registration Fee   : ₹" + registrationFee);
            System.out.println("--------------------------------------");
        }
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Arman Ahmed", "Car", "DL10AA1234");
        Vehicle v2 = new Vehicle("Riya Sharma", "Bike", "UP32BQ5678");

        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        }

        if (v2 instanceof Vehicle) {
            v2.displayDetails();
        }

        Vehicle.updateRegistrationFee(2000.0);

        Vehicle v3 = new Vehicle("Mohit Verma", "Truck", "HR26DX9999");

        if (v3 instanceof Vehicle) {
            v3.displayDetails();
        }
    }
}