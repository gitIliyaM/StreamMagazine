package view.Catalogs;

import common.AppView;
import data.models.Product;
import data.service.ShopService;
import interface_source.pagination.PaginationProducts;
import interface_source.sort.ComparatorProducts;
import interface_source.sort.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class WatchView extends AppView{
    final String Watches = "Watches";
    final ShopService shopService;
    public WatchView(ShopService shopService, ArrayList<AppView> children) {
        super("Watch", children);
        this.shopService = shopService;
    }
    @Override
    public void action() {
        ArrayList<Product> catalog = shopService.getCatalog();
        getPagination(() -> {
            catalog.stream().filter(product -> product.category.equals(Watches)).map(product -> product.id + " " + product.title + " " + product.price).forEach(System.out::println);
        });
        System.out.println();
        System.out.println("������������� ����� �� ���� - �� ��� ���");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        if (userChoice.equals("��") || userChoice.equals("��")) {
            System.out.println("1 - �� �����������, 2 - �� ��������, 3 - ��������");
            userChoice = scanner.nextLine();
            getSortedCatalog(catalog);
        }
    }
    void getPagination(PaginationProducts paginationProducts) {
        paginationProducts.pagination();
    }
    void getSortPrice(Sort sortPrices) {
        sortPrices.sortPrice();
    }
    String getAvailable(boolean available) {
        if (available) {
            return "����� ��������";
        }
        return "����� �� ��������";
    }
    void getSortedCatalog(ArrayList<Product> catalog){
        System.out.println("1 - �� �����������, 2 - �� ��������, 3 - ��������� ������, 4 - �� ��������� ������, 5 - ��������");
        String userChoice = new Scanner(System.in).nextLine();
        Comparator<Product> comparatorProducts = new ComparatorProducts(userChoice);
        switch (userChoice) {
            case "1", "2":
                getSortPrice(() -> {
                    catalog.sort(comparatorProducts);
                    catalog.stream().filter(product -> product.category.equals(Watches)).map(product -> product.id + " " + product.title + " " + product.price + " " + getAvailable(product.available)).forEach(System.out::println);
                });
                break;
            case "3": catalog.stream().filter(product -> product.category.equals(Watches)).filter(product -> getAvailable(product.available).equals("����� ��������")).map(product -> product.id + " " + product.title + " " + product.price + " " + getAvailable(product.available)).forEach(System.out::println);
                break;
            case "4": catalog.stream().filter(product -> product.category.equals(Watches)).filter(product -> getAvailable(product.available).equals("����� �� ��������")).map(product -> product.id + " " + product.title + " " + product.price + " " + getAvailable(product.available)).forEach(System.out::println);
                break;
            default:
                System.out.println("�� ��������� ������� ���������� ��������� ��� ��� ��� ��������");
                getSortedCatalog(catalog);
        }
    }
}
