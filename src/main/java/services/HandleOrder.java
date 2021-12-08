package services;
import model.Order;
import model.Warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandleOrder {

        private List<Order> orderqueue = new ArrayList<>(); // queue linkedlist
        private List<Order> processedorders = new ArrayList<>();
        private Warehouse warehouse;
        private Double profit = 0d;
        private Boolean wasHandled = false;

        public HandleOrder(Warehouse warehouse) {
                this.warehouse = warehouse;
        }

/*        public void handleOrder(Order order){
                if (warehouse.availableinShop(order.getProduct(), order.getAmount())){
                        warehouse.updateInventory(order.getProduct(), order.getAmount());
                        order.setComplete(true);
                        orderqueue.removeIf( (o) -> orderqueue.contains(o));
                        this.profit += order.getAmount()*order.getProduct().getPrice();
                        this.processedorders.add(order);
                        this.wasHandled = true;
                }
                else {
                        this.wasHandled = false;
                        orderqueue.add(order);
                }
        }*/

        public Double getProfit() {
                return profit;
        }

        public Boolean getWasHandled() {
                return wasHandled;
        }

        public List<Order> getOrderqueue() {
                return Collections.unmodifiableList(orderqueue);
        }

        public List<Order> getProcessedorders() {
                return Collections.unmodifiableList(processedorders);
        }

}

//jeśli jest produkt klient kupuje, odpada z kolejki,rejestrowany profit, order
