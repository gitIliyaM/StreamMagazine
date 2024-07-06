package data.models;

public class CartItem {
    /*
    ссылка product на копию Класса Product и количество
    в конструктор можно передать продукт и количество, далее передать объект CartItem в MockCartDataSourceImpl

     */
    public Product product;
    public int count;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
