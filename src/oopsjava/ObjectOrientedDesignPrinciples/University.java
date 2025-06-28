package oopsjava.ObjectOrientedDesignPrinciples;

import java.util.ArrayList;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void showDetails() {
        System.out.println("Faculty: " + name);
    }
}

class UniDepartment {
    String name;

    UniDepartment(String name) {
        this.name = name;
    }

    void showDetails() {
        System.out.println("Department: " + name);
    }
}

public class University {
    String name;
    ArrayList<UniDepartment> departments;
    ArrayList<Faculty> faculties;

    University(String name) {
        this.name = name;
        departments = new ArrayList<>();
        faculties = new ArrayList<>();
    }

    void addDepartment(UniDepartment d) {
        departments.add(d);
    }

    void addFaculty(Faculty f) {
        faculties.add(f);
    }

    void showUniversity() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (UniDepartment d : departments) {
            d.showDetails();
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.showDetails();
        }
    }

    public static void main(String[] args) {
        University u = new University("GLA University");

        UniDepartment d1 = new UniDepartment("Computer Science");
        UniDepartment d2 = new UniDepartment("Mechanical");

        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Dr. Roy");

        u.addDepartment(d1);
        u.addDepartment(d2);
        u.addFaculty(f1);
        u.addFaculty(f2);

        u.showUniversity();
    }
}