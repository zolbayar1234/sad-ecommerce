package mn.edu.ecom.notification;

@FunctionalInterface
public interface NotificationChannel {
    void send(String recipient, String message);
}
