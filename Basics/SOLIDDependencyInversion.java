interface NotificationSender {
    void sendNotification(String message);
}

class EmailNotification implements NotificationSender {

    @Override
    public void sendNotification(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotification implements NotificationSender {

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class NotificationService {

    private NotificationSender sender;

    public NotificationService(NotificationSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String message) {
        sender.sendNotification(message);
    }
}

public class SOLIDDependencyInversion {

    public static void main(String[] args) {

        NotificationSender email = new EmailNotification();

        NotificationService emailService =
                new NotificationService(email);

        emailService.notifyUser("Your application was successful.");

        NotificationSender sms = new SMSNotification();

        NotificationService smsService =
                new NotificationService(sms);

        smsService.notifyUser("Your interview is scheduled.");
    }
}