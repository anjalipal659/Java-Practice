class Student {

    String name;
    int age;
    double marks;

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}

public class ClassesAndObjects {

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = "Anjali";
        s1.age = 21;
        s1.marks = 85.5;

        s1.displayDetails();
    }
}
