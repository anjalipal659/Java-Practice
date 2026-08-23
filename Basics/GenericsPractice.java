import java.util.ArrayList;

class Box<T> {

    private T value;

    Box(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class GenericsPractice {

    // Generic method
    public static <T> void printValue(T value) {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {

        // Integer Box
        Box<Integer> intBox = new Box<>(100);

        System.out.println("Integer: " + intBox.getValue());

        // String Box
        Box<String> stringBox = new Box<>("Java");

        System.out.println("String: " + stringBox.getValue());

        // Double Box
        Box<Double> doubleBox = new Box<>(99.5);

        System.out.println("Double: " + doubleBox.getValue());

        // Generic method
        printValue(50);
        printValue("Hello");
        printValue(25.5);

        // Generic ArrayList
        ArrayList<String> names = new ArrayList<>();

        names.add("Anjali");
        names.add("Rahul");
        names.add("Priya");

        System.out.println("\nNames:");

        for (String name : names) {
            System.out.println(name);
        }
    }
}