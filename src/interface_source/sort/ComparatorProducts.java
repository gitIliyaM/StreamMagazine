package interface_source.sort;

import data.models.Product;

import java.util.Comparator;

public class ComparatorProducts implements Comparator<Product> {
    String number;
    public ComparatorProducts(String numbers){
        this.number = numbers;
    }
    @Override
    public int compare(Product product1, Product product2) {
        if(number.equals("1")){
            return product1.price-product2.price;
        } else {
            return product2.price-product1.price;
        }

    }
}
