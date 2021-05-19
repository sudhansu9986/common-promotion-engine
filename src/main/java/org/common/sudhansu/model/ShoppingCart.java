package org.common.sudhansu.model;

import java.util.List;

/**
 * model class Shopping Cart contains list of cart items and total price of all the items in the cart
 */
public class ShoppingCart {
    private String shoppingCartId;
    private List<CartItem> cartItemList;
    private double totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(String shoppingCartId, List<CartItem> cartItemList, double totalPrice) {
        this.shoppingCartId = shoppingCartId;
        this.cartItemList = cartItemList;
        this.totalPrice = totalPrice;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
