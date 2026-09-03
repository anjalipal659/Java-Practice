class PrototypeStudent implements Cloneable {

    private String name;
    private String course;

    public PrototypeStudent(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }

    @Override
    public PrototypeStudent clone() {
        try {
            return (PrototypeStudent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class DesignPatternPrototype {

    public static void main(String[] args) {

        PrototypeStudent original =
                new PrototypeStudent("Anjali", "MCA");

        PrototypeStudent copy = original.clone();

        System.out.println("Original Object:");
        original.display();

        System.out.println("\nCloned Object:");
        copy.display();

        System.out.println(
                "\nSame Object: " + (original == copy)
        );
    }
}