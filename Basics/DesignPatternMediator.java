interface ChatMediator {

    void sendMessage(String message, User user);

    void addUser(User user);
}

class ChatRoom implements ChatMediator {

    private java.util.List<User> users =
            new java.util.ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {

        for (User user : users) {

            if (user != sender) {
                user.receive(message, sender);
            }
        }
    }
}

class User {

    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {

        System.out.println(
                name + " sends: " + message
        );

        mediator.sendMessage(message, this);
    }

    public void receive(String message, User sender) {

        System.out.println(
                name + " received from "
                + sender.name + ": " + message
        );
    }
}

public class DesignPatternMediator {

    public static void main(String[] args) {

        ChatMediator chatRoom = new ChatRoom();

        User user1 = new User("Anjali", chatRoom);
        User user2 = new User("Rahul", chatRoom);
        User user3 = new User("Priya", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Hello everyone!");

        System.out.println();

        user2.send("Hi Anjali!");
    }
}