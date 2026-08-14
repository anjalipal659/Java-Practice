public class Strings {

    public static void main(String[] args) {

        String name = "Anjali";
        String message = "Java Programming";

        // 1. Print String
        System.out.println(name);

        // 2. Length
        System.out.println("Length = " + name.length());

        // 3. Character at index
        System.out.println("Character at index 2 = " + name.charAt(2));

        // 4. Convert to uppercase
        System.out.println("Uppercase = " + name.toUpperCase());

        // 5. Convert to lowercase
        System.out.println("Lowercase = " + name.toLowerCase());

        // 6. Concatenation
        String firstName = "Anjali";
        String lastName = "Pal";

        String fullName = firstName + " " + lastName;

        System.out.println("Full Name = " + fullName);

        // 7. equals()
        String a = "Java";
        String b = "Java";

        System.out.println("Equal = " + a.equals(b));

        // 8. equalsIgnoreCase()
        String x = "JAVA";
        String y = "java";

        System.out.println("Equal ignoring case = " + x.equalsIgnoreCase(y));

        // 9. contains()
        System.out.println("Contains 'gram' = " + message.contains("gram"));

        // 10. startsWith()
        System.out.println("Starts with Java = " + message.startsWith("Java"));

        // 11. endsWith()
        System.out.println("Ends with ming = " + message.endsWith("ming"));

        // 12. substring()
        System.out.println("Substring = " + message.substring(5));

        // 13. replace()
        System.out.println("Replace = " + message.replace("Java", "Python"));

        // 14. indexOf()
        System.out.println("Index of 'a' = " + message.indexOf("a"));

        // 15. trim()
        String text = "   Hello Java   ";

        System.out.println("Before trim = " + text);
        System.out.println("After trim = " + text.trim());
    }
}