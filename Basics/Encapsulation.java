class Student {

    private String name;
    private int age;

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    // Getter for age
    public int getAge() {
        return age;
    }
}

public class Encapsulation {

    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Anjali");
        student.setAge(21);

        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());

        // Testing validation
        student.setAge(-5);
    }
}