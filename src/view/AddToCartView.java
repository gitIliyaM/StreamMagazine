package view;

import common.AppView;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    final ShopService shopService;
    public AddToCartView(ShopService shopService) {
        super("�������� �����", new ArrayList<>());
        this.shopService = shopService;
    }
    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("������� id ��������");
        String productId = in.nextLine();
        if(checkAvailable(productId)){ // ��������� ��� ������
            System.out.println("������� ����������");
            int count = in.nextInt();
            shopService.addToCart(productId,count);
        } else {
            System.out.println("����� �� �������� ��� �� ����� �� ���������� id ������ �������� ������ �����");
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
