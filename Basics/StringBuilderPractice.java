public class StringBuilderPractice {

    public static void main(String[] args) {

        // 1. Create StringBuilder
        StringBuilder sb = new StringBuilder("Java");

        System.out.println("Original: " + sb);

        // 2. Append
        sb.append(" Programming");

        System.out.println("After append: " + sb);

        // 3. Insert
        sb.insert(5, "Core ");

        System.out.println("After insert: " + sb);

        // 4. Replace
        sb.replace(0, 4, "Advanced");

        System.out.println("After replace: " + sb);

        // 5. Delete
        sb.delete(0, 9);

        System.out.println("After delete: " + sb);

        // 6. Reverse
        sb.reverse();

        System.out.println("After reverse: " + sb);

        // 7. Length
        System.out.println("Length: " + sb.length());

        // 8. Convert to String
        String result = sb.toString();

        System.out.println("String: " + result);
    }
}