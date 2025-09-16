package iuh.fit.se.bai02.dao.implement;

import iuh.fit.se.bai02.model.CartItem;

import java.util.List;

public interface Cart {
    boolean addItem(CartItem cartItem);
    boolean deleteCartItem(String index);
    boolean updateCartItem(String index, int quantity);
    List<CartItem> getCartItem();
    double totalOrder();
    int getLineCount();


}
