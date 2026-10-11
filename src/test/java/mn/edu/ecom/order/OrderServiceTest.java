package mn.edu.ecom.order;

import mn.edu.ecom.cart.Cart;
import mn.edu.ecom.cart.CartItem;
import mn.edu.ecom.order.factory.OrderFactory;
import mn.edu.ecom.order.factory.StandardOrderFactory;
import mn.edu.ecom.order.factory.VipOrderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private Cart testCart;

    @BeforeEach
    void setUp() {
        testCart = new Cart(UUID.randomUUID());
        testCart.addItem(new CartItem("LAPTOP", 1, 1000.0));
        testCart.addItem(new CartItem("MOUSE", 4, 50.0)); // subtotal = 1200
    }

    @Test
    @DisplayName("StandardOrderFactory: tax 10%, no discount => 1320")
    void standardOrderCreation() {
        OrderFactory factory = new StandardOrderFactory();
        Order order = factory.processAndCreate(testCart);
        assertNotNull(order);
        assertEquals("STANDARD", order.getOrderTier());
        assertEquals(1320.0, order.calculateFinalPrice(), 0.01);
        assertNotNull(order.getAuditTimestamp());
    }

    @Test
    @DisplayName("VipOrderFactory applies 15% VIP discount and correct tier tag")
    void vipOrderCreation() {
        OrderFactory factory = new VipOrderFactory();
        Order order = factory.processAndCreate(testCart);
        assertNotNull(order);
        assertEquals("VIP_PRIORITY", order.getOrderTier());
        assertEquals(0.15, order.getDiscountRate(), 0.001);
        assertEquals(1122.0, order.calculateFinalPrice(), 0.01);
    }

    @Test
    @DisplayName("OrderService delegates to the given factory")
    void serviceUsesFactory() {
        Order order = new OrderService().placeOrder(testCart, new VipOrderFactory());
        assertEquals("VIP_PRIORITY", order.getOrderTier());
    }
}
