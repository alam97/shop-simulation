package model;
import services.OrderHandler;
import setvalues.ProductTable;
import setvalues.ShopSupplyTable;

import java.util.*;

public class Shop {

    public static final double MARKUP = 0.2;
    public static final double POLICY_MARKUP = 0.002;
    public static final double CREDIT = 0.002;
    public static final double BUSINESS_COST = 1000.0;
    private ProductTable productTable;
    private Warehouse warehouse;
    private OrderHandler orderHandler;

    public Shop(ProductTable productTable, List<Integer> amounts) {
        this.productTable = productTable;
        warehouse = new Warehouse(createCatalog(),amounts);
        orderHandler = new OrderHandler(warehouse);
    }
    private List<Product> createCatalog(){
       List<Product> catalog = new ArrayList<>();
        Hashtable<Integer, Double> priceTable = productTable.getProductTable();
        Iterator<Integer> itr = priceTable.keySet().iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            catalog.add(new Product(key));
        }
        catalog.sort(Comparator.comparingInt(Product::getId));
        return Collections.unmodifiableList(catalog);
    }


    public List<Product> getCatalog() {
        return warehouse.getInventory();
    }
    public void handleOrder(Order order) { orderHandler.handleOrder(order);}

    public void supplyShop(){
        warehouse.supplyWarehouse();
    }

    @Override
    public String toString() {
        return "Shop{" +
                "productTable=" + productTable +
                ", warehouse=" + warehouse +
                ", orderHandler=" + orderHandler +
                '}';
    }
}
