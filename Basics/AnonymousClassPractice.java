interface Greeting {

    void sayHello();
}

public class AnonymousClassPractice {

    public static void main(String[] args) {

        // Anonymous class
        Greeting greeting = new Greeting() {

            @Override
            public void sayHello() {
                System.out.println("Hello, Anjali!");
            }
        };

        greeting.sayHello();


        // Anonymous class with another implementation
        Greeting secondGreeting = new Greeting() {

            @Override
            public void sayHello() {
                System.out.println("Welcome to Java practice!");
            }
        };

        secondGreeting.sayHello();
    }
}