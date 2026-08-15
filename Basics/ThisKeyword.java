class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }

    void updateAge(int age) {
        this.age = age;
    }
}

public class ThisKeyword {

    public static void main(String[] args) {

        Student s1 = new Student("Anjali", 21);

        s1.display();

        System.out.println("\nAfter updating age:");

        s1.updateAge(22);

        s1.display();
    }
}