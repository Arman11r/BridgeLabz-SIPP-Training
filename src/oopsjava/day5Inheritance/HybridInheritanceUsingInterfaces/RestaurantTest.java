package oopsjava.day5Inheritance.HybridInheritanceUsingInterfaces;

interface Worker {
    void performDuties();
}

class PersonHybrid {
    String name;
    int id;

    PersonHybrid(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void showDetails() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

class Chef extends PersonHybrid implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("Chef is preparing " + specialty + " dishes.");
    }
}

class Waiter extends PersonHybrid implements Worker {
    int tableCount;

    Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    public void performDuties() {
        System.out.println("Waiter is serving " + tableCount + " tables.");
    }
}

public class RestaurantTest {
    public static void main(String[] args) {
        Chef chef = new Chef("Ramesh", 101, "Indian");
        Waiter waiter = new Waiter("Suresh", 201, 5);

        chef.showDetails();
        chef.performDuties();
        System.out.println("-----");

        waiter.showDetails();
        waiter.performDuties();
    }
}