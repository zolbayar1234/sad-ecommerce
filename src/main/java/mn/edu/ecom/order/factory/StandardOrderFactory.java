package mn.edu.ecom.order.factory;

import mn.edu.ecom.cart.Cart;
import mn.edu.ecom.order.Order;

public class StandardOrderFactory extends OrderFactory {
    @Override
    protected Order createOrder(Cart cart) {
        return new Order(cart.getId(), cart.getCustomerId(), cart.getItems(), 0.10, 0.0, "STANDARD");
    }
}
