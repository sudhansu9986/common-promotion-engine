package org.common.sudhansu.model;

/**
 * model class CartItem contains SKU and it's quantity
 */
public class CartItem {
    private String cartItemId;
    private SKU SKU;
    private int quantity;

    public CartItem() {
    }

    public CartItem(String cartItemId, org.common.sudhansu.model.SKU SKU, int quantity) {
        this.cartItemId = cartItemId;
        this.SKU = SKU;
        this.quantity = quantity;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public org.common.sudhansu.model.SKU getSKU() {
        return SKU;
    }

    public void setSKU(org.common.sudhansu.model.SKU SKU) {
        this.SKU = SKU;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
