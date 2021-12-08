package model;
import java.util.*;

public class Warehouse {

    private List<Product> inventory;

    public Warehouse(List<Product> products) {
        inventory = products;
    }

    public void supplyWarehouse(Hashtable<Integer, Integer> supplyChain){
        for (int key : supplyChain.keySet()) {
            inventory.get(key - 1).setAmount(supplyChain.get(key));
        }
    }

    private boolean availableinShop(int product, int amount){
        return (amount <= inventory.get(product).getAmount());
    }

    public List<Product> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    public void updateInventory(int product, int amount){
        if (availableinShop(product, amount)){
            inventory.get(product).setAmount(-amount);
        }
        // else return exception
    }
}
