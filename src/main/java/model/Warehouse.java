package model;
import java.util.*;

public class Warehouse {

    private List<Product> inventory;
    private int[] amounts;

    public Warehouse(List<Product> products, int[] amounts) {
        inventory = products;
        this.amounts=amounts;
    }

    public void supplyWarehouse(){
        for (int i = 0; i < 8; i++) {
           inventory.get(i).setAmount(amounts[i]);
        }
    }

    public boolean availableinShop(Product product){
        return (product.getAmount() <= inventory.get(product.getId()-1).getAmount());
    }

    public List<Product> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    public int getSuppliedAmount(int product) { return amounts[product];}

    public void updateInventory(Product product){
        if (availableinShop(product)){
            inventory.get(product.getId()-1).setAmount(-product.getAmount());
        }
        // else return exception
    }

    private int getAmount ( int productId){
        return amounts[productId-1];
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "inventory=" + inventory +
               // ", amounts=" + amounts +
                '}';
    }
}
