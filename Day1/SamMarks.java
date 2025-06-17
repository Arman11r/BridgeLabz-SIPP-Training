package Day1;
public class SamMarks {
    public static void main(String[] args) {
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        int totalMarks = maths + physics + chemistry;
        double average = totalMarks / 3.0;

        System.out.println("Sam’s average mark in PCM is " + average);
    }
}
