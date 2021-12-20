package services;

import model.Order;
import model.Product;
import model.Shop;
import model.Warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderHandler {

    private List<Order> orderqueue = new ArrayList<>();
    private List<Order> processedorders = new ArrayList<>();
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
        orderqueue.removeIf((o) -> orderqueue.contains(o));
        order.setCompletionStatus(true);
        checkForPolicy(product);
        this.profit += product.getAmount() * product.getPrice();
        this.processedorders.add(order);

    }

    public Double getProfit() {
        return profit;
    }

    public void checkForPolicy(Product product) {
        if (policy.ifPolicy(warehouse.getInventory().get(product.getId()).getAmount(), warehouse.getSuppliedAmount(product.getId()))) {
            product.setPricewithMarkup(Shop.POLICY_MARKUP);
        } else {
            product.setPricewithMarkup(Shop.MARKUP);
        }
    }

    public List<Order> getOrderqueue() {
        return Collections.unmodifiableList(orderqueue);
    }

    public List<Order> getProcessedorders() {
        return Collections.unmodifiableList(processedorders);
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
