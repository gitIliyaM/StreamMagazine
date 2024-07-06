package data.data_source.catalog_sub;

import data.models.CatalogSub;

import java.util.ArrayList;

public class MockCatalogSubDataSource extends CatalogSubDataSource {

    @Override
    public ArrayList<CatalogSub> getCatalogSub() {
        ArrayList<CatalogSub> catalogSub = new ArrayList<>();
        catalogSub.add(new CatalogSub("SmartPhone"));
        catalogSub.add(new CatalogSub("LapTop"));
        catalogSub.add(new CatalogSub("Watch"));
        catalogSub.add(new CatalogSub("Phone"));
        return catalogSub;
    }
}
