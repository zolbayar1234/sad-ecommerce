package mn.edu.ecom.notification;

@FunctionalInterface
public interface NotificationFormatter {
    String format(String orderId, double amount);
}
