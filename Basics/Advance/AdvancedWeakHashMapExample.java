
import java.util.Map;
import java.util.WeakHashMap;

public class AdvancedWeakHashMapExample {

    public static void main(String[] args) {

        Map<Object, String> map = new WeakHashMap<>();

        Object key1 = new Object();
        Object key2 = new Object();

        map.put(key1, "Java");
        map.put(key2, "Python");

        System.out.println("Before GC: " + map.size());

        key1 = null;

        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("After GC: " + map.size());
        System.out.println("Remaining entries: " + map);
    }
}
