package oopsjava.day2ConstructorsInstancevsClassAccesModifiers;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1000;

    public CarRental() {
        customerName = "Unknown";
        carModel = "Basic";
        rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateCost() {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Days: " + rentalDays + ", Total: ₹" + calculateCost());
    }

    public static void main(String[] args) {
        CarRental c1 = new CarRental();
        CarRental c2 = new CarRental("Arman", "SUV", 5);
        c1.display();
        c2.display();
    }
}