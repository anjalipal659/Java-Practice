interface PaymentService {
    void pay(double amount);
}

class UPIService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

class CardPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card.");
    }
}

class OrderService {

    private PaymentService paymentService;

    // Dependency Injection through constructor
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(double amount) {
        System.out.println("Order placed.");
        paymentService.pay(amount);
    }
}

public class DesignPatternDependencyInjection {

    public static void main(String[] args) {

        PaymentService upi = new UPIService();

        OrderService upiOrder =
                new OrderService(upi);

        upiOrder.placeOrder(1500);

        System.out.println();

        PaymentService card = new CardPaymentService();

        OrderService cardOrder =
                new OrderService(card);

        cardOrder.placeOrder(2500);
    }
}