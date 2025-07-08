package Day1LinkedList;

import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManager {
    Student head = null;

    // Add student at beginning
    public void addAtBeginning(Student newStudent) {
        newStudent.next = head;
        head = newStudent;
    }

    // Add student at end
    public void addAtEnd(Student newStudent) {
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newStudent;
        }
    }

    // Add student at a specific position (0-based)
    public void addAtPosition(Student newStudent, int pos) {
        if (pos == 0) {
            addAtBeginning(newStudent);
            return;
        }
        Student temp = head;
        for (int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete student by roll number
    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search by roll number
    public void searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade by roll number
    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all student records
    public void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No records.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Begin 2.Add End 3.Add Pos 4.Delete 5.Search 6.Update Grade 7.Display 8.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    int r = sc.nextInt();
                    String n = sc.next();
                    int a = sc.nextInt();
                    char g = sc.next().charAt(0);
                    Student s = new Student(r, n, a, g);
                    if (choice == 1) manager.addAtBeginning(s);
                    else if (choice == 2) manager.addAtEnd(s);
                    else {
                        System.out.print("Enter position: ");
                        int p = sc.nextInt();
                        manager.addAtPosition(s, p);
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll to delete: ");
                    manager.deleteByRoll(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Roll to search: ");
                    manager.searchByRoll(sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Roll and New Grade: ");
                    manager.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;
                case 7:
                    manager.displayAll();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}