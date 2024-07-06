package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    final ShopService shopService;
    public OrderView(ShopService shopService) {
        super("���������� ������", new ArrayList<>());
        this.shopService = shopService;
    }
    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("������� ���� ���");
        String name = in.nextLine();
        System.out.println("������� ���� �������");
        String phone = in.nextLine();
        System.out.println("������� ���� �����");
        String address = in.nextLine();
        System.out.println("������� ������ ������");
        String paymentType = in.nextLine();
        System.out.println("������� ������ ��������");
        String deliveryTime = in.nextLine();
        shopService.createOrder(name,phone,address,paymentType,deliveryTime);
    }
}
