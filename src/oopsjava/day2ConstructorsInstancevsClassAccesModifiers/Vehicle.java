package oopsjava.day2ConstructorsInstancevsClassAccesModifiers;

public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 1500;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Vehicle Type: " + vehicleType + ", Registration Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Rahul", "Bike");
        Vehicle v2 = new Vehicle("Sneha", "Car");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        Vehicle.updateRegistrationFee(2000);
        v1.displayVehicleDetails();
    }
}