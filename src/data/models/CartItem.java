package data.models;

public class CartItem {
    /*
    ������ product �� ����� ������ Product � ����������
    � ����������� ����� �������� ������� � ����������, ����� �������� ������ CartItem � MockCartDataSourceImpl

     */
    public Product product;
    public int count;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
