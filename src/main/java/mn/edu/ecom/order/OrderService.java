package mn.edu.ecom.order;

import mn.edu.ecom.cart.Cart;

public class OrderService {

    public Order placeOrder(Cart cart, String tier) {
        Order order;
        if (tier.equals("STANDARD")) {
            order = new Order(cart.getId(), cart.getCustomerId(), cart.getItems(), 0.10, 0.0, "STANDARD");
        } else if (tier.equals("VIP")) {
            order = new Order(cart.getId(), cart.getCustomerId(), cart.getItems(), 0.10, 0.15, "VIP_PRIORITY");
        } else {
            throw new IllegalArgumentException("Unknown tier: " + tier);
        }
        order.applyAuditTimestamp();
        return order;
    }
}
