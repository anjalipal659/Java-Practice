class CPU {

    public void start() {
        System.out.println("CPU Started");
    }
}

class Memory {

    public void load() {
        System.out.println("Memory Loaded");
    }
}

class HardDrive {

    public void readData() {
        System.out.println("Data Read from Hard Drive");
    }
}

// Facade
class ComputerFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void startComputer() {

        System.out.println("Starting Computer...");

        cpu.start();
        memory.load();
        hardDrive.readData();

        System.out.println("Computer Started Successfully");
    }
}

public class DesignPatternFacade {

    public static void main(String[] args) {

        ComputerFacade computer = new ComputerFacade();

        computer.startComputer();
    }
}