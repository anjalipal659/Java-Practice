
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AdvancedConsumerSupplierExample {

    public static void main(String[] args) {

        Supplier<String> studentSupplier =
                () -> "Anjali Pal";

        Consumer<String> studentConsumer =
                name -> System.out.println("Student: " + name);

        String name = studentSupplier.get();

        studentConsumer.accept(name);

        Supplier<Integer> marksSupplier =
                () -> 85;

        Consumer<Integer> marksConsumer =
                marks -> System.out.println("Marks: " + marks);

        marksConsumer.accept(marksSupplier.get());
    }
}
