package oopsjava.day5Inheritance.HierarchialInheritance;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void showDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolTest {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student s = new Student("Riya", 17, "12th Grade");
        Staff staff = new Staff("Mrs. Das", 35, "Administration");

        t.showDetails();
        t.displayRole();
        System.out.println("-----");

        s.showDetails();
        s.displayRole();
        System.out.println("-----");

        staff.showDetails();
        staff.displayRole();
    }
}