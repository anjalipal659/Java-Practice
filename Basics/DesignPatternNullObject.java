interface UserNotification {
    void send(String message);
}

class RealUserNotification implements UserNotification {

    private String userName;

    public RealUserNotification(String userName) {
        this.userName = userName;
    }

    @Override
    public void send(String message) {
        System.out.println(
                "Notification sent to " + userName + ": " + message
        );
    }
}

class NullUserNotification implements UserNotification {

    @Override
    public void send(String message) {
        System.out.println(
                "No user available. Notification skipped."
        );
    }
}

class NotificationFactory {

    public static UserNotification getNotificationUser(
            String userName) {

        if (userName == null || userName.isEmpty()) {
            return new NullUserNotification();
        }

        return new RealUserNotification(userName);
    }
}

public class DesignPatternNullObject {

    public static void main(String[] args) {

        UserNotification user1 =
                NotificationFactory.getNotificationUser("Anjali");

        user1.send("Your interview is scheduled.");

        UserNotification user2 =
                NotificationFactory.getNotificationUser("");

        user2.send("Your application was submitted.");
    }
}