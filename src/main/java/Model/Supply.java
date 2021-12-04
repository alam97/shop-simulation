/* different based on the amount of products they supply */

package Model;

import Model.Product;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Supply {
    Hashtable<Product, Integer> supplychain = new Hashtable<>();
    public Supply() {}

    public Map<Product, Integer> getSupply(){
        return Collections.unmodifiableMap(this.supplychain);
    }

    public void generateAmount(Product product, int min, int max){
        int amount = (int) ((Math.random() * (max - min)) + min);
        this.supplychain.put(product, amount);
    }

    public void clearChain(){
        this.supplychain.clear();
    }
}
