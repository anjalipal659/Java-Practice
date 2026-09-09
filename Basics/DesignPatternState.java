interface ATMState {

    void insertCard();

    void withdrawMoney();
}

// State 1
class NoCardState implements ATMState {

    @Override
    public void insertCard() {
        System.out.println("Card inserted");
    }

    @Override
    public void withdrawMoney() {
        System.out.println("Please insert your card first");
    }
}

// State 2
class CardInsertedState implements ATMState {

    @Override
    public void insertCard() {
        System.out.println("Card is already inserted");
    }

    @Override
    public void withdrawMoney() {
        System.out.println("Money withdrawn successfully");
    }
}

// Context
class ATM {

    private ATMState state;

    public ATM() {
        state = new NoCardState();
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void insertCard() {
        state.insertCard();
    }

    public void withdrawMoney() {
        state.withdrawMoney();
    }
}

public class DesignPatternState {

    public static void main(String[] args) {

        ATM atm = new ATM();

        System.out.println("Before inserting card:");
        atm.withdrawMoney();

        System.out.println("\nInserting card:");
        atm.insertCard();

        atm.setState(new CardInsertedState());

        System.out.println("\nAfter inserting card:");
        atm.withdrawMoney();

        System.out.println("\nTrying to insert card again:");
        atm.insertCard();
    }
}