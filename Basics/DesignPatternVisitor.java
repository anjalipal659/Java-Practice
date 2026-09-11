interface Visitor {

    void visit(Book book);

    void visit(Laptop laptop);
}

interface Item {

    void accept(Visitor visitor);
}

class Book implements Item {

    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Laptop implements Item {

    private String brand;
    private double price;

    public Laptop(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Visitor
class DiscountVisitor implements Visitor {

    @Override
    public void visit(Book book) {

        double discount = book.getPrice() * 0.10;

        System.out.println(
                "Book: " + book.getTitle()
        );

        System.out.println(
                "Original Price: ₹" + book.getPrice()
        );

        System.out.println(
                "Discount: ₹" + discount
        );
    }

    @Override
    public void visit(Laptop laptop) {

        double discount = laptop.getPrice() * 0.05;

        System.out.println(
                "Laptop: " + laptop.getBrand()
        );

        System.out.println(
                "Original Price: ₹" + laptop.getPrice()
        );

        System.out.println(
                "Discount: ₹" + discount
        );
    }
}

public class DesignPatternVisitor {

    public static void main(String[] args) {

        Item book =
                new Book("Java Programming", 500);

        Item laptop =
                new Laptop("Dell", 60000);

        Visitor discountVisitor =
                new DiscountVisitor();

        book.accept(discountVisitor);

        System.out.println();

        laptop.accept(discountVisitor);
    }
}