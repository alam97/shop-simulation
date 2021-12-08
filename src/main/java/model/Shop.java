package model;

import interfaces.IHandleOrder;
import interfaces.IPolicy;
import setvalues.ProductTable;

import java.util.*;

public class Shop {

    private static final double markup = 0.2;
    private static final double policyMarkup = 0.002;
    private static final double credit = 0.002;
    private static final double businessCost = 1000.0;
    private ProductTable productTable;
    private Warehouse warehouse;

    public Shop(ProductTable productTable) {
        this.productTable = productTable;
        warehouse = new Warehouse(createCatalog());
    }
    private List<Product> createCatalog(){
       List<Product> catalog = new ArrayList<>();
        Hashtable<Integer, Double> priceTable = productTable.getProductTable();
        Iterator<Integer> itr = priceTable.keySet().iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            catalog.add(new Product(key, Math.round(priceTable.get(key)*markup+priceTable.get(key))));
        }
        catalog.sort(Comparator.comparingInt(Product::getId));
        return Collections.unmodifiableList(catalog);
    }


    public List<Product> getCatalog() {
        return warehouse.getInventory();
    }


}
