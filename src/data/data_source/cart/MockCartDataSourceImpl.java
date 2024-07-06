package data.data_source.cart;

import data.models.CartItem;
import data.models.Product;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource {
    private ArrayList<CartItem> cart = new ArrayList<>();
    @Override
    public void addToCart(Product product, int count) { // addToCart(CartItem cartItem)
        cart.add(new CartItem(product, count));  // cart.add(cartItem);
    }
    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }

}
