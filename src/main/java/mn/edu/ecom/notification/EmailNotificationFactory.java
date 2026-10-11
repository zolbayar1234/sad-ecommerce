package mn.edu.ecom.notification;

public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public NotificationChannel createChannel() {
        return (recipient, msg) -> System.out.println("SMTP TLS email to " + recipient + ": " + msg);
    }

    @Override
    public NotificationFormatter createFormatter() {
        return (id, amt) -> "<html><body>Order #" + id + " Total: $" + amt + "</body></html>";
    }
}
