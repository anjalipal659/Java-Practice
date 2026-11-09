
import java.lang.reflect.Method;
import java.lang.reflect.Field;

class PlacementStudent {
    private String name = "Anjali";
    public int score = 85;

    public void study() {
        System.out.println("Student is studying Java.");
    }
}

public class AdvancedReflectionExample {

    public static void main(String[] args) {

        Class<?> cls = PlacementStudent.class;

        System.out.println("Class Name: " + cls.getName());

        System.out.println("\nMethods:");

        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        System.out.println("\nFields:");

        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
}
