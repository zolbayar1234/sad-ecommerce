package mn.edu.ecom.notification;

public class SmsNotificationFactory implements NotificationFactory {
    @Override
    public NotificationChannel createChannel() {
        return (recipient, msg) -> System.out.println("GSM SMS to " + recipient + ": " + msg);
    }

    @Override
    public NotificationFormatter createFormatter() {
        return (id, amt) -> "Order #" + id + " confirmed. Total: $" + amt + ". ecom.mn/t";
    }
}
