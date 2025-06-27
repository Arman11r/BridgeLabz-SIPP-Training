package oopsjava.day3thisStaticFinalKeywordAndInstanceOfOperators;

class Patient {
    static String hospitalName = "CityCare Hospital";
    private String name;
    private int age;
    private String ailment;
    private final String patientID;
    private static int totalPatients = 0;

    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name : " + hospitalName);
            System.out.println("Patient ID    : " + patientID);
            System.out.println("Name          : " + name);
            System.out.println("Age           : " + age);
            System.out.println("Ailment       : " + ailment);
            System.out.println("-------------------------------");
        }
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Arman Ahmed", 29, "Fever", "PAT001");
        Patient p2 = new Patient("Sneha Kumari", 34, "Fracture", "PAT002");

        if (p1 instanceof Patient) {
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayDetails();
        }

        Patient.getTotalPatients();
    }
}