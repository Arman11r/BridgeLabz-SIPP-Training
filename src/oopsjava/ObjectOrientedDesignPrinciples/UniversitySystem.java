package oopsjava.ObjectOrientedDesignPrinciples;

import java.util.ArrayList;

class UniCourse {
    String courseName;
    UniProfessor professor;
    ArrayList<UniStudent> students;

    UniCourse(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    void assignProfessor(UniProfessor p) {
        this.professor = p;
        System.out.println("Course " + courseName + " assigned to Professor " + p.name);
    }

    void enrollStudent(UniStudent s) {
        students.add(s);
        s.courses.add(this);
        System.out.println("Student " + s.name + " enrolled in " + courseName);
    }

    void showDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Taught by: " + professor.name);
        }
        System.out.println("Enrolled Students:");
        for (UniStudent s : students) {
            System.out.println("- " + s.name);
        }
    }
}

class UniStudent {
    String name;
    ArrayList<UniCourse> courses;

    UniStudent(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    void showCourses() {
        System.out.println("Courses of " + name + ":");
        for (UniCourse c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class UniProfessor {
    String name;

    UniProfessor(String name) {
        this.name = name;
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        UniCourse c1 = new UniCourse("Data Structures");
        UniCourse c2 = new UniCourse("DBMS");

        UniStudent s1 = new UniStudent("Arman");
        UniStudent s2 = new UniStudent("Riya");

        UniProfessor p1 = new UniProfessor("Dr. Rao");
        UniProfessor p2 = new UniProfessor("Dr. Sen");

        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s1);

        s1.showCourses();
        c1.showDetails();
        c2.showDetails();
    }
}