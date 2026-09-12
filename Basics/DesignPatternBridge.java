interface Device {

    void turnOn();

    void turnOff();

    void setVolume(int volume);
}

// Concrete Implementation 1
class TV implements Device {

    @Override
    public void turnOn() {
        System.out.println("TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is OFF");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV Volume: " + volume);
    }
}

// Concrete Implementation 2
class Radio implements Device {

    @Override
    public void turnOn() {
        System.out.println("Radio is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is OFF");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Radio Volume: " + volume);
    }
}

// Abstraction
abstract class Remote {

    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

// Refined Abstraction
class BasicRemote extends Remote {

    public BasicRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
        System.out.println("Device Muted");
    }
}

public class DesignPatternBridge {

    public static void main(String[] args) {

        Device tv = new TV();

        Remote tvRemote = new BasicRemote(tv);

        System.out.println("Controlling TV:");

        tvRemote.turnOn();
        tvRemote.setVolume(20);
        tvRemote.turnOff();

        System.out.println("\nControlling Radio:");

        Device radio = new Radio();

        Remote radioRemote = new BasicRemote(radio);

        radioRemote.turnOn();
        radioRemote.setVolume(15);

        ((BasicRemote) radioRemote).mute();

        radioRemote.turnOff();
    }
}