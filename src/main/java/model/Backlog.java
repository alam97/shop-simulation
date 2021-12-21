package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class Backlog {

    private List<ArrayList<Order>> allOrders;
    private double profitPerMonth = 0d;
    private double totalProfit = 0d;
    private ArrayList<Product> inventory;

    public Backlog() {
        allOrders = new ArrayList<>();
        inventory = new ArrayList<>();
    }

    // na poczatku miesiaca pobieram liste z magazynu, zeby wiedziec ile produktow zamowiono
    public void loadInventory(ArrayList<Product> warehouseInventory){
        inventory = warehouseInventory;
    }

    public void addOrdersToBacklog(int key, ArrayList<Order> orders){
        // wykonywane na koniec miesiaca
        allOrders.add(key, orders);
    }

    public double getShopProfit(double profit, double credit, double businessCost){
       // Arrays.stream(inventory.stream().map(p -> p.getAmount() * p.getPrice()).collect(Collectors.toList()).toArray()).mapToDouble(Double::doubleValue).sum();
        //double forCredit = p -> p.getAmount()
        return profit - businessCost;
    }

}
