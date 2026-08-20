import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {

    int marks;
    String name;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks;
    }

    void display() {
        System.out.println(name + " - " + marks);
    }
}

public class ComparablePractice {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Anjali", 85));
        students.add(new Student("Rahul", 72));
        students.add(new Student("Priya", 92));
        students.add(new Student("Aman", 78));

        System.out.println("Before Sorting:");

        for (Student student : students) {
            student.display();
        }

        // Sort by marks
        Collections.sort(students);

        System.out.println("\nAfter Sorting:");

        for (Student student : students) {
            student.display();
        }
    }
}