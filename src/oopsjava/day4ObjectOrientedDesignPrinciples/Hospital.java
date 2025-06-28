package oopsjava.day4ObjectOrientedDesignPrinciples;

import java.util.ArrayList;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Doctor {
    String name;
    ArrayList<Patient> patients;

    Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    void consult(Patient p) {
        patients.add(p);
        System.out.println("Dr. " + name + " is consulting patient " + p.getName());
    }

    void showPatients() {
        System.out.println("Dr. " + name + "'s Patients:");
        for (Patient p : patients) {
            System.out.println("- " + p.getName());
        }
    }
}

public class Hospital {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Smith");
        Doctor d2 = new Doctor("Jones");

        Patient p1 = new Patient("Arman");
        Patient p2 = new Patient("Riya");
        Patient p3 = new Patient("Aman");

        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p1);
        d2.consult(p3);

        d1.showPatients();
        d2.showPatients();
    }
}