package model;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class Warehouse {

    Hashtable<Product, Integer> inventory = new Hashtable<>();

    public Warehouse() {}

    public boolean availableinShop(Product product, int amount){
        return (amount <= inventory.get(product));
    }

    public Map<Product, Integer> getInventory() {
        return Collections.unmodifiableMap(this.inventory);
    }

    public void updateInventory(Product product, int amount){
        if (availableinShop(product, amount)){
            inventory.replace(product, inventory.get(product) - amount);
        }
        // else return exception
    }

    public void supplyInventory(Supply supply) {
        supply.getSupply().forEach((k, v) -> {
            inventory.replace(k, v+inventory.get(k));
        });
    }
}
