interface Coffee {

    String getDescription();

    double getCost();
}

// Basic coffee
class BasicCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 50;
    }
}

// Base Decorator
class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

// Milk Decorator
class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 20;
    }
}

// Sugar Decorator
class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }
}

public class DesignPatternDecorator {

    public static void main(String[] args) {

        Coffee coffee = new BasicCoffee();

        System.out.println(
                coffee.getDescription()
                + " = ₹" + coffee.getCost()
        );

        coffee = new MilkDecorator(coffee);

        System.out.println(
                coffee.getDescription()
                + " = ₹" + coffee.getCost()
        );

        coffee = new SugarDecorator(coffee);

        System.out.println(
                coffee.getDescription()
                + " = ₹" + coffee.getCost()
        );
    }
}