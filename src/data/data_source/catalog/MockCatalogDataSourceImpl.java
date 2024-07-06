package data.data_source.catalog;

import data.models.Product;

import java.util.ArrayList;

public class MockCatalogDataSourceImpl extends CatalogDataSource {
    @Override
    public ArrayList<Product> getCatalog() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1", "SmartPhone Nokia ","SmartPhones","Best Phone",1000, true));
        products.add(new Product("id2", "SmartPhone Nokia S ","SmartPhones","Best Phone",3000, false));
        products.add(new Product("id3", "LapTop Samsung","LapTops","Best LapTop",2000, true));
        products.add(new Product("id4", "LapTop Apple","LapTops","Best LapTop",1000, false));
        products.add(new Product("id5", "Watch Nexus","Watches","Best Watch",500, false));
        products.add(new Product("id6", "Watch Apple","Watches","Best Watch",800, true));
        products.add(new Product("id7", "Phone SSP4","Phones","Best Phone",100, true));
        products.add(new Product("id8", "Phone SSP3","Phones","Best Phone",300, true));
        return products;
    }
}
