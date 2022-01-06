package model;

import simulation.Sim;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Backlog {

    private int id;
    private Hashtable<Integer, List<Order>> allOrders;
    private double[] profitPerMonth = new double[Sim.getMonthDuration()];
    private List<Product> inventory;
    private List<Product> supplied;
    private double supplyCreditCost;
    private double scale = Math.pow(10, 2);
    private int count = 0;

    public Backlog(int id, List<Product> supplies) {
        this.id = id;
        allOrders = new Hashtable<>();
        inventory = new ArrayList<>();
        supplied = supplies;
        supplyCreditCost = supplied.stream().mapToDouble(product -> product.getTotalPrice()).sum() * Shop.CREDIT;
    }

    // na koniec miesiaca pobieram liste z magazynu, zeby wiedziec ile jest produktow na stanie
    public void loadInventory(List<Product> warehouseInventory){
        inventory = warehouseInventory;
    }

    public void addOrdersToBacklog(List<Order> orders){
        // wykonywane na koniec miesiaca
        allOrders.put(Sim.month, orders);
        profitPerMonth[Sim.month-1] = orders.stream().mapToDouble(o -> o.getProduct().getTotalPrice()).sum();
    }

    public double getShopProfit(boolean endOfYear){
        double profitFromOrders = 0d;
        if (!endOfYear) {
            profitFromOrders = profitPerMonth[Sim.month-1];
        }
        else {
            profitFromOrders = allOrders.values().stream().mapToDouble(l -> l.stream().mapToDouble(o -> o.getProduct().getTotalPrice()).sum()).sum();
        }
        double profit = supplyCreditCost + profitFromOrders - Shop.BUSINESS_COST;
        // zaokraglam do 2 miejsc po przecinku dla estetyki
        return Math.round(profit * scale) / scale;
    }

    private int numberOfAllOrders(){
        Set<Integer> months = allOrders.keySet();
        for (Integer key: months){
            count += allOrders.get(key).size();
        }
        return count;
    }

    @Override
    public String toString() {
        return "============= END OF MONTH " + Sim.month + " REPORT " +  System.lineSeparator() +
                "Shop number # " + id + System.lineSeparator() +
                " - number of all orders = " + numberOfAllOrders() +  System.lineSeparator() +
                " - totalProfit =" + getShopProfit(false) +  System.lineSeparator() +
                " - Inventory =" + inventory  + System.lineSeparator() + " " ;
    }

}
