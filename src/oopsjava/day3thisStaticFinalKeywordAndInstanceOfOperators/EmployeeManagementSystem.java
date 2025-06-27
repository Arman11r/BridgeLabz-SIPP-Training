package oopsjava.day3thisStaticFinalKeywordAndInstanceOfOperators;

class Employee {
    static String companyName = "TechNova Solutions";
    private String name;
    private final int id;
    private String designation;
    private static int totalEmployees = 0;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name : " + companyName);
            System.out.println("Employee Name: " + name);
            System.out.println("Employee ID  : " + id);
            System.out.println("Designation  : " + designation);
            System.out.println("-------------------------------");
        }
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Arman Ahmed", 101, "Software Engineer");
        Employee e2 = new Employee("Riya Sharma", 102, "QA Analyst");

        if (e1 instanceof Employee) {
            e1.displayDetails();
        }

        if (e2 instanceof Employee) {
            e2.displayDetails();
        }

        Employee.displayTotalEmployees();
    }
}