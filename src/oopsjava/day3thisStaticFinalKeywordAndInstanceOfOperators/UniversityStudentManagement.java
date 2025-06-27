package oopsjava.day3thisStaticFinalKeywordAndInstanceOfOperators;

class Student {
    static String universityName = "National Institute of Technology";
    private String name;
    private final int rollNumber;
    private char grade;
    private static int totalStudents = 0;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University   : " + universityName);
            System.out.println("Name         : " + name);
            System.out.println("Roll Number  : " + rollNumber);
            System.out.println("Grade        : " + grade);
            System.out.println("-----------------------------");
        }
    }

    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for Roll No " + rollNumber);
        }
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student s1 = new Student("Arman Ahmed", 101, 'A');
        Student s2 = new Student("Priya Sharma", 102, 'B');

        if (s1 instanceof Student) {
            s1.displayDetails();
        }

        if (s2 instanceof Student) {
            s2.displayDetails();
        }

        s2.updateGrade('A');

        if (s2 instanceof Student) {
            s2.displayDetails();
        }

        Student.displayTotalStudents();
    }
}