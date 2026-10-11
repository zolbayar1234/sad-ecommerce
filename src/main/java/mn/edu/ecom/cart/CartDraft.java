package mn.edu.ecom.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Prototype: бэлэн сагсны загварыг хуулбарлаж шинэ сагс үүсгэнэ
public class CartDraft implements Cloneable {
    private UUID draftId = UUID.randomUUID();
    private final String templateName;
    private List<CartItem> items = new ArrayList<>();

    public CartDraft(String templateName) {
        this.templateName = templateName;
    }

    public void addItem(CartItem item) { items.add(item); }
    public UUID getDraftId() { return draftId; }
    public String getTemplateName() { return templateName; }
    public List<CartItem> getItems() { return items; }

    @Override
    public CartDraft clone() {
        try {
            CartDraft copy = (CartDraft) super.clone();
            copy.draftId = UUID.randomUUID();      // шинэ identity
            copy.items = new ArrayList<>();        // шинэ жагсаалт (deep copy)
            for (CartItem item : this.items) {
                copy.items.add(new CartItem(item.getSku(), item.getQuantity(), item.getUnitPrice()));
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone supported", e);
        }
    }
}
