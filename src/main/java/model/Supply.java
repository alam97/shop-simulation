/* different based on the amount of products they supply */

package model;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Supply {
    private Hashtable<Product, Integer> supplyChain = new Hashtable<>();
    public Supply() {}

    public Map<Product, Integer> getSupply(){
        return Collections.unmodifiableMap(supplyChain);
    }

    public void generateAmount(Product product, int min, int max){
        int amount = (int) ((Math.random() * (max - min)) + min);
        supplyChain.put(product, amount);
    }

    public void clearChain(){
        supplyChain.clear();
    }
}
