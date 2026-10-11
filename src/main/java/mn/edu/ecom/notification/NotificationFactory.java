package mn.edu.ecom.notification;

// Abstract Factory: хоёр хамтран ажилладаг бүтээгдэхүүний гэр бүл үүсгэнэ
public interface NotificationFactory {
    NotificationChannel createChannel();
    NotificationFormatter createFormatter();
}
