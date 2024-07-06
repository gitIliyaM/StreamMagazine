package view;

import common.AppView;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    final ShopService shopService;
    public AddToCartView(ShopService shopService) {
        super("Добавить товар", new ArrayList<>());
        this.shopService = shopService;
    }
    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id продукта");
        String productId = in.nextLine();
        if(checkAvailable(productId)){ // переделал эту строку
            System.out.println("Введите количество");
            int count = in.nextInt();
            shopService.addToCart(productId,count);
        } else {
            System.out.println("товар не доступен или вы ввели не правильный id товара выберите другой товар");
        }
    }
    boolean checkAvailable(String userID){
        ArrayList<Product> catalog = shopService.getCatalog();
        for(Product p: catalog){
            if(p.id.contains(userID) && p.available){
                return true;
            }
        }
        return false;
    }
}
