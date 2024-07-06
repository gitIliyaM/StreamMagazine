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

public class PhoneView extends AppView {
    final String Phones = "Phones";
    final ShopService shopService;
    public PhoneView(ShopService shopService, ArrayList<AppView> children) {
        super("Phone", children);
        this.shopService = shopService;
    }
    @Override
    public void action() {
        ArrayList<Product> catalog = shopService.getCatalog();
        getPagination(() -> {
            catalog.stream().filter(product -> product.category.equals(Phones)).map(product -> product.id + " " + product.title + " " + product.price).forEach(System.out::println);
        });
        System.out.println();
        System.out.println("Отсортировать товар по Цене - Да или Нет");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        if (userChoice.equals("Да") || userChoice.equals("да")) {
            System.out.println("1 - по возрастанию, 2 - по убыванию, 3 - отменить");
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
            return "Товар доступен";
        }
        return "Товар не доступен";
    }
    void getSortedCatalog(ArrayList<Product> catalog){
        System.out.println("1 - по возрастанию, 2 - по убыванию, 3 - Доступные товары, 4 - Не доступные товары, 5 - отменить");
        String userChoice = new Scanner(System.in).nextLine();
        Comparator<Product> comparatorProducts = new ComparatorProducts(userChoice);
        switch (userChoice) {
            case "1", "2":
                getSortPrice(() -> {
                    catalog.sort(comparatorProducts);
                    catalog.stream().filter(product -> product.category.equals(Phones)).map(product -> product.id + " " + product.title + " " + product.price + " " + getAvailable(product.available)).forEach(System.out::println);
                });
                break;
            case "3": catalog.stream().filter(product -> product.category.equals(Phones)).filter(product -> getAvailable(product.available).equals("Товар доступен")).map(product -> product.id + " " + product.title + " " + product.price + " " + getAvailable(product.available)).forEach(System.out::println);
                break;
            case "4": catalog.stream().filter(product -> product.category.equals(Phones)).filter(product -> getAvailable(product.available).equals("Товар не доступен")).map(product -> product.id + " " + product.title + " " + product.price + " " + getAvailable(product.available)).forEach(System.out::println);
                break;
            default:
                System.out.println("Не правильно указали сортировку повторите еще раз или отмените");
                getSortedCatalog(catalog);
        }
    }
}
