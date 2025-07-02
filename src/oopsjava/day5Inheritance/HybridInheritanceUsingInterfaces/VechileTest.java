package oopsjava.day5Inheritance.HybridInheritanceUsingInterfaces;

interface Refuelable {
    void refuel();
}

class VehicleBase {
    String model;
    int maxSpeed;

    VehicleBase(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void showInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends VehicleBase {
    int batteryLevel;

    ElectricVehicle(String model, int maxSpeed, int batteryLevel) {
        super(model, maxSpeed);
        this.batteryLevel = batteryLevel;
    }

    void charge() {
        System.out.println("Charging to " + batteryLevel + "% battery.");
    }
}

class PetrolVehicle extends VehicleBase implements Refuelable {
    int fuelCapacity;

    PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    public void refuel() {
        System.out.println("Refueling with " + fuelCapacity + " liters of petrol.");
    }
}

public class VechileTest {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 80);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 40);

        ev.showInfo();
        ev.charge();
        System.out.println("-----");

        pv.showInfo();
        pv.refuel();
    }
}