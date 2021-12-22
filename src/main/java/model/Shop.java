package model;
import services.OrderHandler;
import setvalues.ProductTable;
import simulation.Sim;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Shop implements Runnable{

    public static final double MARKUP = 0.2;
    public static final double POLICY_MARKUP = 0.002;
    public static final double CREDIT = 0.002;
    public static final double BUSINESS_COST = 1000.0;
    private static AtomicInteger counter = new AtomicInteger(0);
    private ProductTable productTable;
    private Warehouse warehouse;
    private OrderHandler orderHandler;
    private Backlog backlog;
    private int id;

    private Thread thread;
    private BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public Shop(ProductTable productTable, int[] amounts) {
        this.productTable = productTable;
        warehouse = new Warehouse(createCatalog(),amounts);
        orderHandler = new OrderHandler(warehouse);
        id = counter.incrementAndGet();
        backlog = new Backlog();
        thread = new Thread(this);
    }

    public void startHandlingOrders(){
        thread.start();
    }


    private List<Product> createCatalog(){
       List<Product> catalog = new ArrayList<>();
        Hashtable<Integer, Double> priceTable = productTable.getProductTable();
        Iterator<Integer> itr = priceTable.keySet().iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            catalog.add(new Product(key));
        }
        catalog.sort(Comparator.comparingInt(Product::getId));
        return Collections.unmodifiableList(catalog);
    }


    public List<Product> getCatalog() {
        return warehouse.getInventory();
    }


/*    public void queueOrder(Order order){
        try {
            orderQueue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public void handleOrder(Order order) {
        orderHandler.handleOrder(order);
    }

    public OrderHandler getOrderHandler() {
        return orderHandler;
    }

    public int getId() { return id; }

    public void supplyShop(){
        warehouse.supplyWarehouse();
    }

    public Backlog getBacklog() {
        return backlog;
    }

    @Override
    public String toString() {
        return "Shop{" +
               // "productTable=" + productTable +
               // ", warehouse=" + warehouse +
              //  ", orderHandler=" + orderHandler +
              //  ", backlog=" + backlog +
                ", id=" + id +
                '}';
    }

    @Override
    public void run() {
/*        while (Sim.day < Sim.finalday){ //wykonywac dla wartosci day mniejszej niz dzien po ostatnim dniu symulacji. Nie mozna robić tak zeby take wywołano gdy juz nie bedzie wysylanych kolejnych orderow
            try {
                Order order = orderQueue.take();
                handleOrder(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
