class OuterClass {

    private String message = "Hello from Outer Class";

    // Inner class
    class InnerClass {

        void display() {
            System.out.println(message);
        }
    }

    // Static nested class
    static class StaticInnerClass {

        void show() {
            System.out.println("Hello from Static Inner Class");
        }
    }
}

public class InnerClassPractice {

    public static void main(String[] args) {

        // Create Outer class object
        OuterClass outer = new OuterClass();

        // Create Inner class object
        OuterClass.InnerClass inner =
                outer.new InnerClass();

        inner.display();


        // Create Static Inner class object
        OuterClass.StaticInnerClass staticInner =
                new OuterClass.StaticInnerClass();

        staticInner.show();
    }
}