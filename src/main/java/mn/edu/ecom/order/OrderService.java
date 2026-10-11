package mn.edu.ecom.order;

import mn.edu.ecom.cart.Cart;
import mn.edu.ecom.order.factory.OrderFactory;

public class OrderService {

    // if/else байхгүй: шинэ tier нэмэхэд энэ класс өөрчлөгдөхгүй (OCP)
    public Order placeOrder(Cart cart, OrderFactory factory) {
        return factory.processAndCreate(cart);
    }
}
