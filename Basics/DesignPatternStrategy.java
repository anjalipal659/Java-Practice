interface PaymentStrategy {

    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

class UPIPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CashPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Cash");
    }
}

// Context
class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {
        strategy.pay(amount);
    }
}

public class DesignPatternStrategy {

    public static void main(String[] args) {

        PaymentContext payment1 =
                new PaymentContext(new CreditCardPayment());

        payment1.makePayment(1000);

        PaymentContext payment2 =
                new PaymentContext(new UPIPayment());

        payment2.makePayment(500);

        PaymentContext payment3 =
                new PaymentContext(new CashPayment());

        payment3.makePayment(300);
    }
}