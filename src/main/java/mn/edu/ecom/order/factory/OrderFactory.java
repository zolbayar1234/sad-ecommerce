package mn.edu.ecom.order.factory;

import mn.edu.ecom.cart.Cart;
import mn.edu.ecom.order.Order;

public abstract class OrderFactory {

    public Order processAndCreate(Cart cart) {
        Order order = createOrder(cart);
        order.applyAuditTimestamp();
        return order;
    }

    // Factory Method: дэд классууд өөрсдөө хэрэгжүүлнэ
    protected abstract Order createOrder(Cart cart);
}
