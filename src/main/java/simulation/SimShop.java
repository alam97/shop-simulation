package simulation;

import model.Client;
import model.Order;
import model.Product;
import model.Shop;
import services.AmountChoice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimShop implements Runnable{

    private Shop shop;
    private List<Client> clients;
    private List<Order> orders = new LinkedList<>();
    private BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private Thread thread;

    public SimShop(Shop shop, List<Client> clients) {
        this.shop = shop;
        this.clients = clients;
        thread = new Thread(this);
    }

    public void startHandlingOrders(){
        thread.start();
    }

    public void stopSimulation() { thread.interrupt();}

    public void queueOrder(Order order){
    //    System.out.println("======== " + order);
        try {
            orderQueue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     //   System.out.println(orderQueue);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Shop getShop() {
        return shop;
    }

    public BlockingQueue<Order> getOrderQueue() {
        return orderQueue;
    }

    @Override
    public void run() {
        while (Sim.day < Sim.finalday){
            try {
                Order order = orderQueue.take();
                shop.handleOrder(order);
                System.out.println(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "SimShop{" +
                "shop=" + shop +
                ", clients=" + clients +
                ", orders=" + shop.getOrderHandler() +
                ", orderQueue=" + orderQueue +
                '}';
    }

    /*    public void newClients(List<Client> c){
        clients.clear();
        clients.addAll(c);
    }

    // clients make orders
    private void clientsMakeOrders(){
        AmountChoice amountChoice = new AmountChoice();
        clients.forEach((c) -> orders.add(new Order(shop, c, Sim.getDayofmonth())));
    }*/
}
