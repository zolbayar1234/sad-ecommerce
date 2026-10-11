package mn.edu.ecom.order;

import mn.edu.ecom.cart.CartItem;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final UUID customerId;
    private final List<CartItem> items;
    private final double taxRate;
    private final double discountRate;
    private final String orderTier;
    private Instant auditTimestamp;

    // Telescoping constructor: 6 параметр, дараалал андуурахад амархан, шалгалт байхгүй
    public Order(UUID orderId, UUID customerId, List<CartItem> items,
                 double taxRate, double discountRate, String orderTier) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.taxRate = taxRate;
        this.discountRate = discountRate;
        this.orderTier = orderTier;
    }

    public void applyAuditTimestamp() { this.auditTimestamp = Instant.now(); }

    public double calculateFinalPrice() {
        double subtotal = items.stream().mapToDouble(CartItem::getSubtotal).sum();
        return subtotal * (1 - discountRate) * (1 + taxRate);
    }

    public UUID getOrderId() { return orderId; }
    public UUID getCustomerId() { return customerId; }
    public List<CartItem> getItems() { return items; }
    public double getTaxRate() { return taxRate; }
    public double getDiscountRate() { return discountRate; }
    public String getOrderTier() { return orderTier; }
    public Instant getAuditTimestamp() { return auditTimestamp; }
}
