interface Payment {

    void pay(double amount);

    void refund(double amount);
}

class UPI implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " through UPI");
    }
}

class CreditCard implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " through Credit Card");
    }
}

public class Interface {

    public static void main(String[] args) {

        Payment payment;

        payment = new UPI();
        payment.pay(1000);
        payment.refund(500);

        System.out.println();

        payment = new CreditCard();
        payment.pay(2000);
        payment.refund(1000);
    }
}
