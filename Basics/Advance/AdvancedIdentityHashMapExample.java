
import java.util.IdentityHashMap;
import java.util.Map;

public class AdvancedIdentityHashMapExample {

    public static void main(String[] args) {

        Map<String, Integer> map = new IdentityHashMap<>();

        String key1 = new String("Java");
        String key2 = new String("Java");

        map.put(key1, 100);
        map.put(key2, 200);

        System.out.println("Map size: " + map.size());
        System.out.println("Key 1 value: " + map.get(key1));
        System.out.println("Key 2 value: " + map.get(key2));

        System.out.println("Same content: " + key1.equals(key2));
        System.out.println("Same reference: " + (key1 == key2));
    }
}
