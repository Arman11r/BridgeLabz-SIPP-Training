package oopsjava.day5Inheritance;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String schoolName;

    Intern(String name, int id, double salary, String schoolName) {
        super(name, id, salary);
        this.schoolName = schoolName;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("School Name: " + schoolName);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Alice", 101, 80000, 10),
            new Developer("Bob", 102, 60000, "Java"),
            new Intern("Charlie", 103, 15000, "GLA University")
        };

        for (Employee emp : employees) {
            emp.displayDetails(); // Polymorphic call
            System.out.println("----");
        }
    }
}