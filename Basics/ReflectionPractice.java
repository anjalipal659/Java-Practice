import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee {

    private int id = 101;
    private String name = "Anjali";

    public void display() {
        System.out.println("Employee: " + name);
    }

    public void work() {
        System.out.println(name + " is working.");
    }
}

public class ReflectionPractice {

    public static void main(String[] args) {

        try {

            // 1. Get Class object
            Class<?> employeeClass =
                    Class.forName("Employee");

            System.out.println("Class Name: "
                    + employeeClass.getName());


            // 2. Get declared fields
            System.out.println("\nFields:");

            Field[] fields =
                    employeeClass.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(
                        field.getName()
                                + " : "
                                + field.getType().getSimpleName()
                );
            }


            // 3. Get declared methods
            System.out.println("\nMethods:");

            Method[] methods =
                    employeeClass.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method.getName());
            }


            // 4. Create object using Reflection
            Object employee =
                    employeeClass.getDeclaredConstructor()
                            .newInstance();

            System.out.println("\nObject created successfully!");


            // 5. Invoke public method
            Method displayMethod =
                    employeeClass.getMethod("display");

            displayMethod.invoke(employee);


            // 6. Access private field
            Field nameField =
                    employeeClass.getDeclaredField("name");

            nameField.setAccessible(true);

            String name =
                    (String) nameField.get(employee);

            System.out.println(
                    "Private Name: " + name
            );

        } catch (Exception e) {

            System.out.println(
                    "Reflection Error: "
                            + e.getMessage()
            );
        }
    }
}