package model;
import setvalues.ShopSupplyTable;

import java.util.*;

public class Warehouse {

    private List<Product> inventory;
    private List<Integer> amounts;

    public Warehouse(List<Product> products, List<Integer> amounts) {
        inventory = products;
        this.amounts=amounts;
    }

    public void supplyWarehouse(){
        for (int i = 0; i < 8; i++) {
           inventory.get(i).setAmount(amounts.get(i));
        }
    }

    public boolean availableinShop(Product product){
        return (product.getAmount() <= inventory.get(product.getId()-1).getAmount());
    }

    public List<Product> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    public int getSuppliedAmount(int product) { return amounts.get(product);}

    public void updateInventory(Product product){
        if (availableinShop(product)){
            inventory.get(product.getId()-1).setAmount(-product.getAmount());
        }
        // else return exception
    }

    private int getAmount ( int productId){
        return amounts.get(productId-1);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "inventory=" + inventory +
                ", amounts=" + amounts +
                '}';
    }
}
