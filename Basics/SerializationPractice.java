import java.io.*;

class Student implements Serializable {

    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class SerializationPractice {

    public static void main(String[] args) {

        Student student =
                new Student(101, "Anjali", 85.5);

        // Serialization
        try {
            FileOutputStream file =
                    new FileOutputStream("student.txt");

            ObjectOutputStream output =
                    new ObjectOutputStream(file);

            output.writeObject(student);

            output.close();
            file.close();

            System.out.println("Object serialized successfully!");

        } catch (IOException e) {
            System.out.println("Serialization Error: "
                    + e.getMessage());
        }


        // Deserialization
        try {
            FileInputStream file =
                    new FileInputStream("student.txt");

            ObjectInputStream input =
                    new ObjectInputStream(file);

            Student savedStudent =
                    (Student) input.readObject();

            input.close();
            file.close();

            System.out.println("\nObject deserialized successfully!");

            savedStudent.display();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: "
                    + e.getMessage());
        }
    }
}