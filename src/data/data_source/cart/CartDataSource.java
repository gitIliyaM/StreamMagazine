package data.data_source.cart;

import data.models.CartItem;
import data.models.Product;

import java.util.ArrayList;

public abstract class CartDataSource {

    public abstract void addToCart(Product product, int count); // addToCart(CartItem cartItem)
    public abstract ArrayList<CartItem> getCart();
}
