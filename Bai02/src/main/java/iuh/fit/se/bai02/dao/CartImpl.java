package iuh.fit.se.bai02.dao;

import iuh.fit.se.bai02.dao.implement.Cart;
import iuh.fit.se.bai02.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {
    private List<CartItem> items=new ArrayList<CartItem>();

    @Override
    public boolean addItem(CartItem cartItem) {
        return items.add(cartItem);
    }

    @Override
    public boolean deleteCartItem(String index) {
        return items.removeIf(x-> x.getId()==Integer.parseInt(index));
    }

    @Override
    public boolean updateCartItem(String index, int quantity) {
        CartItem cartItem=items.stream().filter(x->x.getId()==Integer.parseInt(index))
                .findFirst().orElse(null);
        if(cartItem!=null){
            cartItem.setQuantity(quantity);
            return true;
        }
        return false;
    }

    @Override
    public List<CartItem> getCartItem() {
        return items;
    }

    @Override
    public double totalOrder() {
        double total=0;
        for(int i=0; i<items.size();i++){
            CartItem cartItem=items.get(i);
            total=total+cartItem.getTotalPrice();
        }
        return total;
    }

    @Override
    public int getLineCount() {
        return items.size();

    }
}
