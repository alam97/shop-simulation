package Model;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Warehouse {

    Hashtable<Product, Integer> inventory = new Hashtable<>();

    public Warehouse() {}

    public Boolean availableinShop(Product product, int amount){
        return (amount <= this.inventory.get(product)) ? true : false;
    }

    public Map getInventory() {
        return Collections.unmodifiableMap(this.inventory);
    }

    public void updateInventory(Product product, int amount){
        if (availableinShop(product, amount)){
            this.inventory.replace(product, this.inventory.get(product) - amount);
        }
        // else return exception
    }

    public void supplyInventory(Supply supply) {
        supply.getSupply().forEach((k, v) -> {
            this.inventory.replace(k, v+this.inventory.get(k));
        });
    }
}
