package oopsjava.day2ConstructorsInstancevsClassAccesModifiers;

public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "EduHub";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks, Fee: ₹" + fee + ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 8, 5000);
        Course c2 = new Course("Python", 6, 4500);
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        Course.updateInstituteName("SkillLab");
        c1.displayCourseDetails();
    }
}