package mn.edu.ecom.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartDraftTest {

    private CartDraft template() {
        CartDraft d = new CartDraft("Monthly groceries");
        d.addItem(new CartItem("RICE", 2, 5.0));
        d.addItem(new CartItem("MILK", 4, 2.5));
        return d;
    }

    @Test
    @DisplayName("clone() copies content but gets a fresh draftId")
    void cloneHasSameContentNewId() {
        CartDraft original = template();
        CartDraft copy = original.clone();
        assertNotSame(original, copy);
        assertNotEquals(original.getDraftId(), copy.getDraftId());
        assertEquals(original.getTemplateName(), copy.getTemplateName());
        assertEquals(2, copy.getItems().size());
        assertEquals("RICE", copy.getItems().get(0).getSku());
    }

    @Test
    @DisplayName("clone() is a deep copy: changing the copy does not affect the original")
    void deepCopyCheck() {
        CartDraft original = template();
        CartDraft copy = original.clone();
        assertNotSame(original.getItems(), copy.getItems());
        assertNotSame(original.getItems().get(0), copy.getItems().get(0));
        copy.addItem(new CartItem("EGGS", 10, 0.5));
        assertEquals(2, original.getItems().size());
        assertEquals(3, copy.getItems().size());
    }
}
