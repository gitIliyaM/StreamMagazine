package data.models;

public class Product {
    public String id;
    public String title, category;
    public String description;
    public int price;
    public boolean available ;

    public Product(String id, String title, String category, String description, int price, boolean available) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.price = price;
        this.available = available;
    }
    public int getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
}
