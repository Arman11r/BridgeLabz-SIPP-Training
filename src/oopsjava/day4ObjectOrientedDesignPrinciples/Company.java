package oopsjava.day4ObjectOrientedDesignPrinciples;

import java.util.ArrayList;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void showDetails() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    String deptName;
    ArrayList<Employee> employees;

    Department(String deptName) {
        this.deptName = deptName;
        employees = new ArrayList<>();
    }

    void addEmployee(String name) {
        employees.add(new Employee(name));
    }

    void showDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.showDetails();
        }
    }
}

public class Company {
    String companyName;
    ArrayList<Department> departments;

    Company(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void showCompany() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }

    public static void main(String[] args) {
        Company c = new Company("TechNova");
        Department d1 = new Department("Engineering");
        Department d2 = new Department("Marketing");

        d1.addEmployee("Alice");
        d1.addEmployee("Bob");

        d2.addEmployee("Charlie");

        c.addDepartment(d1);
        c.addDepartment(d2);

        c.showCompany();
    }
}