interface DiscountStrategy {
    double calculateDiscount(double price);
}

class RegularDiscount implements DiscountStrategy {

    public double calculateDiscount(double price) {
        return price * 0.05;
    }
}

class PremiumDiscount implements DiscountStrategy {

    public double calculateDiscount(double price) {
        return price * 0.20;
    }
}

class DiscountCalculator {

    public double finalPrice(double price, DiscountStrategy strategy) {
        double discount = strategy.calculateDiscount(price);
        return price - discount;
    }
}

public class SOLIDOpenClosed {

    public static void main(String[] args) {

        DiscountCalculator calculator = new DiscountCalculator();

        double price = 1000;

        double regularPrice =
                calculator.finalPrice(price, new RegularDiscount());

        double premiumPrice =
                calculator.finalPrice(price, new PremiumDiscount());

        System.out.println("Original Price: ₹" + price);
        System.out.println("Regular Customer Price: ₹" + regularPrice);
        System.out.println("Premium Customer Price: ₹" + premiumPrice);
    }
}