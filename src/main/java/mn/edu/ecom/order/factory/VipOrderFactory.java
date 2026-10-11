package mn.edu.ecom.order.factory;

import mn.edu.ecom.cart.Cart;
import mn.edu.ecom.order.Order;

public class VipOrderFactory extends OrderFactory {
    @Override
    protected Order createOrder(Cart cart) {
        return new Order(cart.getId(), cart.getCustomerId(), cart.getItems(), 0.10, 0.15, "VIP_PRIORITY");
    }
}
