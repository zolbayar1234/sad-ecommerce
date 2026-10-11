package mn.edu.ecom.notification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    @DisplayName("Email family produces HTML formatter and a working channel")
    void emailFamily() {
        NotificationFactory f = new EmailNotificationFactory();
        String body = f.createFormatter().format("A1", 99.5);
        assertTrue(body.startsWith("<html>"));
        assertTrue(body.contains("A1"));
        assertDoesNotThrow(() -> f.createChannel().send("a@b.mn", body));
    }

    @Test
    @DisplayName("SMS family produces short text formatter, different from Email")
    void smsFamily() {
        NotificationFactory sms = new SmsNotificationFactory();
        NotificationFactory email = new EmailNotificationFactory();
        String smsBody = sms.createFormatter().format("A1", 99.5);
        assertTrue(smsBody.contains("ecom.mn/t"));
        assertFalse(smsBody.contains("<html>"));
        assertNotEquals(smsBody, email.createFormatter().format("A1", 99.5));
        assertEquals(2, NotificationFactory.class.getDeclaredMethods().length);
    }
}
