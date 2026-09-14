interface LSPBird {
    void eat();
}

interface LSPFlyingBird extends LSPBird {
    void fly();
}

class LSPSparrow implements LSPFlyingBird {

    @Override
    public void eat() {
        System.out.println("Sparrow is eating.");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}

class LSPPenguin implements LSPBird {

    @Override
    public void eat() {
        System.out.println("Penguin is eating.");
    }
}

public class SOLIDLiskovSubstitution {

    public static void main(String[] args) {

        LSPBird bird1 = new LSPSparrow();
        bird1.eat();

        LSPFlyingBird flyingBird = new LSPSparrow();
        flyingBird.fly();

        LSPBird bird2 = new LSPPenguin();
        bird2.eat();
    }
}