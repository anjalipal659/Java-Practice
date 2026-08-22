import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {

    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(name + " - " + marks);
    }
}

public class ComparatorPractice {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Anjali", 85));
        students.add(new Student("Rahul", 72));
        students.add(new Student("Priya", 92));
        students.add(new Student("Aman", 78));

        System.out.println("Original List:");

        for (Student student : students) {
            student.display();
        }

        // Sort by marks - ascending
        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return s1.marks - s2.marks;
            }
        });

        System.out.println("\nSorted by Marks:");

        for (Student student : students) {
            student.display();
        }

        // Sort by name - alphabetical order
        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });

        System.out.println("\nSorted by Name:");

        for (Student student : students) {
            student.display();
        }
    }
}