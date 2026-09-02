interface Notification {
    void send();
}

class EmailNotification implements Notification {

    public void send() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification implements Notification {

    public void send() {
        System.out.println("Sending SMS Notification");
    }
}

class PushNotification implements Notification {

    public void send() {
        System.out.println("Sending Push Notification");
    }
}

class NotificationFactory {

    public static Notification createNotification(String type) {

        switch (type.toLowerCase()) {

            case "email":
                return new EmailNotification();

            case "sms":
                return new SMSNotification();

            case "push":
                return new PushNotification();

            default:
                throw new IllegalArgumentException(
                        "Unknown notification type"
                );
        }
    }
}

public class DesignPatternFactory {

    public static void main(String[] args) {

        Notification n1 =
                NotificationFactory.createNotification("email");

        Notification n2 =
                NotificationFactory.createNotification("sms");

        Notification n3 =
                NotificationFactory.createNotification("push");

        n1.send();
        n2.send();
        n3.send();
    }
}