package oopsjava.day6EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.*;

// Interface: Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Abstract Class: Employee
abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters (Encapsulation)
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract Method
    public abstract double calculateSalary();

    // Concrete Method
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: ₹" + baseSalary);
    }
}

// FullTimeEmployee Class
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double bonus;

    public FullTimeEmployee(String employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// PartTimeEmployee Class
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double ratePerHour;

    public PartTimeEmployee(String employeeId, String name, double baseSalary, int hoursWorked, double ratePerHour) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * ratePerHour;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee("EMP101", "Arman", 30000, 5000);
        emp1.assignDepartment("Engineering");

        PartTimeEmployee emp2 = new PartTimeEmployee("EMP102", "Riya", 0, 80, 250);
        emp2.assignDepartment("Support");

        // Add to polymorphic list
        employeeList.add(emp1);
        employeeList.add(emp2);

        // Process Employees
        for (Employee e : employeeList) {
            e.displayDetails();
            System.out.println("Calculated Salary: ₹" + e.calculateSalary());
            if (e instanceof Department) {
                System.out.println(((Department) e).getDepartmentDetails());
            }
            System.out.println("--------------");
        }
    }
}