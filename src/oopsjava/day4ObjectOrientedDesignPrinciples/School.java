package oopsjava.day4ObjectOrientedDesignPrinciples;

import java.util.ArrayList;

class Course {
    String courseName;
    ArrayList<Student> students;

    Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    void enroll(Student s) {
        students.add(s);
        s.courses.add(this);
    }

    void showEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println("Student: " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses;

    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("Enrolled in: " + c.courseName);
        }
    }
}

class School {
    String schoolName;
    ArrayList<Student> students;

    School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            s.showCourses();
        }
    }

    public static void main(String[] args) {
        School school = new School("Global High");

        Student s1 = new Student("Riya");
        Student s2 = new Student("Kunal");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        c1.enroll(s1);
        c2.enroll(s1);
        c1.enroll(s2);

        school.addStudent(s1);
        school.addStudent(s2);

        school.showStudents();
        c1.showEnrolledStudents();
        c2.showEnrolledStudents();
    }
}