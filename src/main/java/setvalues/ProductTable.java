package setvalues;

import java.util.Hashtable;

public class ProductTable {

    public Hashtable<Integer, Double> getProductTable() {
        Hashtable<Integer, Double> productTable = new Hashtable<>();
        productTable.put(8, 1666.66);
        productTable.put(7, 1438.09);
        productTable.put(6, 1209.52);
        productTable.put(5, 980.95);
        productTable.put(4, 752.37);
        productTable.put(3, 523.80);
        productTable.put(2, 295.23);
        productTable.put(1, 66.66);
        return productTable;
    }
}
