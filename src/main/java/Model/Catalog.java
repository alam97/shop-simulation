/* Single Class Responsibility:
    Catalog is just responsible for itself, the entity
 */

package Model;

import java.util.*;

public class Catalog {
    private List<Product> catalog = new ArrayList<>();
    private Hashtable<Integer, Double> prod_price;

    public Catalog(Hashtable<Integer, Double> prod_price) {
        this.prod_price = prod_price;
    }

    public void setMarkup(double markup) {
        this.catalog.forEach((p) -> p.setPrice(p.getPrice()*markup));
    }

    public void setCatalog(int items) {
        for (int i = 0; i < items+1 ; i++){
            this.catalog.add(i, new Product(i, this.prod_price.get(i)));
        }
    }

    public List<Product> getCatalog() {
        return Collections.unmodifiableList(catalog);
    }
    public Map<Integer, Double> getPriceBoard() { return Collections.unmodifiableMap(prod_price); }
}
