package simulation;
import model.*;
import services.AmountChoice;
import services.ClientFactory;
import services.DayChoice;
import setvalues.ClientGroupPref;
import setvalues.ProductTable;
import setvalues.ShopSupplyTable;

import java.util.*;

public class Sim {

    private ClientFactory clientFactory;
    private Shop shop;
    private ProductTable productTable;
    private Warehouse warehouse;
    private List<Client> clients;
    private Map<Integer,List<Client>> clientDays;
    private List<Order> orders = new LinkedList<>();
    // if day % 30 == 0 then month++
    private int month = 1;
    // global days
    private int day = 0;

    public Sim(int numOfClients, int duration, ProductTable productTable) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        clients = clientFactory.getClients(numOfClients);
        this.productTable = productTable;
        shop = new Shop(productTable);
        warehouse = new Warehouse(shop.getCatalog());
    }


    public void startSimulation(){
       // System.out.println("= = = = S T A R T  = = = =");
        assignDaytoClient();
        clientsMakeOrders();
      //  System.out.println("Clients and days: " + clientDays);
      //  System.out.println("Their orders: " + orders);

    }

    private void assignDaytoClient(){
        DayChoice dayChoice = new DayChoice();
        clientDays = new Hashtable<>();
        for (Client client : clients) {
            int day = dayChoice.getDay(new Random(), client.getPreference());
            clientDays.putIfAbsent(day,new ArrayList<>(List.of(client)));
            if(!clientDays.containsKey(day)){
                clientDays.get(day).add(client);
            }
        }
    }


    private void clientsMakeOrders(){
        AmountChoice amountChoice = new AmountChoice();
        clients.forEach((c) -> orders.add(new Order(shop, c, new Product(c.getPreference(), amountChoice.amountChoice(new Random(), c.getPreference())))));
    }

    public Shop getShop() {
        return shop;
    }
    public void supplyShop(ShopSupplyTable shopSupplyTable){
        warehouse.supplyWarehouse(shopSupplyTable.getSupplyPolicy());
     //   System.out.println(warehouse.getInventory());
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    private Order makeOrder(Shop shop, Client client, int amount){
        return new Order(shop, client, new Product(client.getPreference(), amount));
    }

    public void giveRating(){
        orders.forEach( o -> o.setSatifactionRate(10));
        orders.add(new Order(shop, clients.get(0), new Product(clients.get(0).getPreference(), 1)));
    }

    // de facto ta funkcja powinna byc w shopchoice xD
    public double getRating(Client client){
        // !!!! Skoro wybor sklepu jest uzalezniony od ocen z poprzednich zakupow w tym samym sklepie
        // potrzebuje
        //todo za pomoca streama i metody filter wyliczyc ocene dla przekazanego klienta
        // ponizsze zwraca dla danego klienta, srednia jego ocen
        double count = 0;
        int n = 0;
        for (Order order: orders) {
            if(order.getClient().equals(client)){
                count += order.getSatifactionRate();
                n++;
        }
        }
        return count/n;
    }
    
    public int getDayofmonth(){
        int dayofmonth = day - 30*(month-1);
        return dayofmonth == 0 ? 1 : dayofmonth;
    }

}
