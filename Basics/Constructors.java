class Student {

    String name;
    int age;

    // Default constructor
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Constructors {

    public static void main(String[] args) {

        // Using default constructor
        Student s1 = new Student();
        s1.display();

        System.out.println();

        // Using parameterized constructor
        Student s2 = new Student("Anjali", 21);
        s2.display();
    }
}