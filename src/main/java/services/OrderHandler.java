package services;

import model.Order;
import model.Product;
import model.Shop;
import model.Warehouse;
import simulation.Sim;

import java.util.*;

public class OrderHandler {

    private Queue<Order> orderqueue = new LinkedList<>();
    private Queue<Order> processedorders = new LinkedList<>();
    private Warehouse warehouse;
    private Double profit = 0d;
    Policy policy = new Policy();

    public OrderHandler(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void handleOrder(Order order) {
        Product product = order.getProduct();
        if (!warehouse.availableinShop(product)) {
            orderqueue.add(order);
            return;
        }

        warehouse.updateInventory(product);
        order.setDayOfCompletion(Sim.day);
        checkForPolicy(product); //ustawia promocje w produkcie
        this.profit += product.getTotalPrice();
        this.processedorders.add(order);
    }

    public void handleOldOrders(){
        List<Order> oldOrders = new ArrayList<>(orderqueue);
        orderqueue.clear();
        oldOrders.forEach(o -> handleOrder(o));
    }


    public Double getProfit() {
        return profit;
    }

    public void checkForPolicy(Product product) {
        if (policy.ifPolicy(warehouse.getInventory().get(product.getId()-1).getAmount(), warehouse.getSuppliedAmount(product.getId()-1))) {
            product.setPricewithMarkup(Shop.POLICY_MARKUP);
        } else {
            product.setPricewithMarkup(Shop.MARKUP);
        }
    }

    public List<Order> getOrderqueue() {
        return Collections.unmodifiableList(new ArrayList<>(orderqueue));
    }

    public List<Order> getProcessedorders() {
        return Collections.unmodifiableList(new ArrayList<>(processedorders));
    }

        @Override
        public String toString() {
                return "OrderHandler{" +
                        "orderqueue=" + orderqueue +
                        ", processedorders=" + processedorders +
                        ", warehouse=" + warehouse +
                        ", profit=" + profit +
                        ", policy=" + policy +
                        '}';
        }
}
