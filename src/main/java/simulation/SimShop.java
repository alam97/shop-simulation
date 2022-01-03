package simulation;

import model.Client;
import model.Order;
import model.Shop;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class SimShop implements Runnable{

    private Shop shop;
    private List<Client> clients;
    private List<Order> orders = new LinkedList<>();
    private BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private AtomicBoolean running = new AtomicBoolean(false);
    private Thread thread;

    public SimShop(Shop shop, List<Client> clients) {
        this.shop = shop;
        this.clients = clients;
        thread = new Thread(this);
    }

    public void newClients(List<Client> newClients) {
        if (clients != null || !clients.isEmpty()) {
            clients.clear();
        }
        clients.addAll(orderQueue.stream().map(Order::getClient).collect(Collectors.toList()));
        if (newClients != null) {
            clients.addAll(newClients);
        }
    }

    public void startHandlingOrders(){
        thread.start();
    }


    public void stop() {
        running.set(true);
    }

    public synchronized void queueOrder(Order order){
        try {
            orderQueue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public Shop getShop() {
        return shop;
    }

    public synchronized void addToBacklog(){
        shop.getBacklog().addOrdersToBacklog(shop.getOrderHandler().getProcessedorders());
    }

    public List<Order> ordersPerClient(Client client){
       return shop.getOrderHandler().getProcessedorders().stream().filter(o -> o.getClient().equals(client)).collect(Collectors.toList());
    }

    @Override
    public void run() {
        while (!running.get()) {
            if (Sim.day == Sim.finalDay+1){
                stop();
            }
            try {
                if ( orderQueue.isEmpty()) {
                    continue;
                }
                else {
                    Order order = orderQueue.take();
                    shop.handleOrder(order);
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "SimShop{" +
                "shop=" + shop +
             //   ", clients=" + clients +
            //    ", orders=" + shop.getOrderHandler() +
                ", orderQueue=" + orderQueue + System.lineSeparator() +
                ", orders=" + shop.getOrderHandler() +
                '}';
    }

}
