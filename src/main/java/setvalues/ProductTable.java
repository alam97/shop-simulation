package setvalues;

/* Why Singleton? How I understood the project is that
* there is a fixed table of values for each product
* Why? Because each index/product have the exact same price in each shop
* Therefore, I assumed that by creating a Singleton, I will save on the memory
* by having one instance of a fixed table that each class has an access to.
* When it comes to modifying, well, of course it's impossible to modify this table
* during the run of the program, but we can impose changes after/before running it.
* This, I assume would also act as a sort of privacy/security shield. */
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class ProductTable {

    public Hashtable<Integer, Double> getProductTable() {
        Hashtable<Integer, Double> productTable = new Hashtable<>();
        productTable.put(1, 66.66);
        productTable.put(2, 295.23);
        productTable.put(3, 523.80);
        productTable.put(4, 752.37);
        productTable.put(5, 980.95);
        productTable.put(6, 1209.52);
        productTable.put(7, 1438.09);
        productTable.put(8, 1666.66);
        return productTable;
    }
}
