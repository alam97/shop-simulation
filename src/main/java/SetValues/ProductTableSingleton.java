package SetValues;

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

public enum ProductTableSingleton {
    INSTANCE;
    private final Hashtable<Integer, Double> product_table;

    // private constructor
    ProductTableSingleton() {
        Hashtable<Integer, Double> product_table = new Hashtable<>();
        product_table.put(1, 66.66);
        product_table.put(2, 295.23);
        product_table.put(3, 523.80);
        product_table.put(4, 752.37);
        product_table.put(5, 980.95);
        product_table.put(6, 1209.52);
        product_table.put(7, 1438.09);
        product_table.put(8, 1666.66);
        this.product_table = product_table;

    }

    public boolean containsProduct(Integer product) {
        return this.product_table.containsKey(product);
    }
    public Map<Integer, Double> getProduct_table() { return Collections.unmodifiableMap(product_table); }

}
