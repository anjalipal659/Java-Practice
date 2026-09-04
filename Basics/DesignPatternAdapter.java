interface Payment {

    void pay();
}

// Existing class
class OldPaymentSystem {

    public void makePayment() {
        System.out.println("Payment made using Old Payment System");
    }
}

// Adapter
class PaymentAdapter implements Payment {

    private OldPaymentSystem oldPaymentSystem;

    public PaymentAdapter() {
        oldPaymentSystem = new OldPaymentSystem();
    }

    @Override
    public void pay() {
        oldPaymentSystem.makePayment();
    }
}

public class DesignPatternAdapter {

    public static void main(String[] args) {

        Payment payment = new PaymentAdapter();

        payment.pay();
    }
}