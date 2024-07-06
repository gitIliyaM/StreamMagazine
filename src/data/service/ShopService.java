package data.service;

import data.data_source.cart.CartDataSource;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.order.OrderDataSource;
import data.models.CartItem;
import data.models.Order;
import data.models.Product;

import java.util.ArrayList;

public class ShopService {
    final CartDataSource cartDataSource;
    final CatalogDataSource catalogDataSource;
    final OrderDataSource orderDataSource;

    public ShopService(CartDataSource cartDataSource, CatalogDataSource catalogDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }
    public ArrayList<Product> getCatalog(){
        return catalogDataSource.getCatalog();
    }
    public boolean addToCart(String productId, int count){
        ArrayList<Product> products = getCatalog();
        for(Product p : products){
            if(p.id.equals(productId)){
                cartDataSource.addToCart(p,count);
                return true;
            }
        } return false;
    }
    public ArrayList<CartItem> getCart(){
       return cartDataSource.getCart();
    }
    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime){
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name,phone,address,paymentType,deliveryTime,cart);
        orderDataSource.createOrder(newOrder);
    }

}
