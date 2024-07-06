import common.AppView;
import common.PageLoop;
import data.data_source.cart.CartDataSource;
import data.data_source.cart.MockCartDataSourceImpl;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.catalog.MockCatalogDataSourceImpl;
import data.data_source.order.MockOrderDataSourceImpl;
import data.data_source.order.OrderDataSource;
import data.service.ShopService;
import view.*;
import view.Catalogs.LapTopView;
import view.Catalogs.PhoneView;
import view.Catalogs.SmartPhoneView;
import view.Catalogs.WatchView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // interface Available - не стал использовать, решил объединить всю сортировку и фильтр в один метод
        // void getSortedCatalog(), конечно если создать отдельный метод под фильтры, то будет работать как метод void getSortedCatalog()
        // или можно реализовать интерфейсы в классах вызывать их разные методы без лямбд ....много вариантов, остановился на этом
        // сейчас это не так важно, переделать можно в любой момент, чтобы структура была как изначально заложена
        // фильтры и сортировка отдельно
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(cartDataSource,catalogDataSource,orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);
        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);

        ArrayList<AppView> catalogsView = getCatalogs(shopService,catalogChildren);

        AppView catalogView = new CatalogView(shopService,catalogsView);

        AppView cartView = new CartView(shopService);
        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);

        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();

        /*System.out.println(shopService.getCatalog());
        System.out.println(shopService.getCart());
        System.out.println(shopService.addToCart(shopService.getCatalog().get(0).id,5));
        System.out.println(shopService.addToCart("qwerty",5));
        System.out.println(shopService.getCart());*/
    }
    public static ArrayList<AppView> getCatalogs(ShopService shopService,ArrayList<AppView> catalogChildren){
        AppView laptopView = new LapTopView(shopService,catalogChildren);
        AppView PhoneView = new PhoneView(shopService,catalogChildren);
        AppView SmartPhoneView = new SmartPhoneView(shopService,catalogChildren);
        AppView WatchView = new WatchView(shopService,catalogChildren);

        ArrayList<AppView> catalogs = new ArrayList<>();
        catalogs.add(laptopView);
        catalogs.add(PhoneView);
        catalogs.add(SmartPhoneView);
        catalogs.add(WatchView);

        return catalogs;
    }

}
