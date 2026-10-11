package mn.edu.ecom.order;

import mn.edu.ecom.cart.Cart;
import mn.edu.ecom.cart.CartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private Cart testCart;

    @BeforeEach
    void setUp() {
        testCart = new Cart(UUID.randomUUID());
        testCart.addItem(new CartItem("LAPTOP", 1, 1000.0));
        testCart.addItem(new CartItem("MOUSE", 4, 50.0));
    }

    @Test
    void standardOrder() {
        Order order = new OrderService().placeOrder(testCart, "STANDARD");
        assertEquals("STANDARD", order.getOrderTier());
        assertEquals(1320.0, order.calculateFinalPrice(), 0.01);
    }

    @Test
    void vipOrder() {
        Order order = new OrderService().placeOrder(testCart, "VIP");
        assertEquals("VIP_PRIORITY", order.getOrderTier());
        assertEquals(1122.0, order.calculateFinalPrice(), 0.01);
    }
}