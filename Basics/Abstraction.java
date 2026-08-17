abstract class Vehicle {

    // Abstract method
    abstract void start();

    // Normal method
    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike starts with a button");
    }
}

public class Abstraction {

    public static void main(String[] args) {

        Vehicle car = new Car();
        car.start();
        car.stop();

        System.out.println();

        Vehicle bike = new Bike();
        bike.start();
        bike.stop();
    }
}