package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    final ShopService shopService;
    public OrderView(ShopService shopService) {
        super("ќформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }
    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("¬ведите свое им€");
        String name = in.nextLine();
        System.out.println("¬ведите свое телефон");
        String phone = in.nextLine();
        System.out.println("¬ведите свое адрес");
        String address = in.nextLine();
        System.out.println("¬ведите способ оплаты");
        String paymentType = in.nextLine();
        System.out.println("¬ведите способ доставки");
        String deliveryTime = in.nextLine();
        shopService.createOrder(name,phone,address,paymentType,deliveryTime);
    }
}
