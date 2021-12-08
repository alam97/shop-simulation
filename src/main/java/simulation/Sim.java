package simulation;
import model.*;
import services.AmountChoice;
import services.ClientFactory;
import services.DayChoice;
import setvalues.ClientGroupPref;
import setvalues.PoissonLambda;
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
    private int month = 1;

    public Sim(int numOfClients, int duration, ProductTable productTable) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        clients = clientFactory.getClients(numOfClients);
        this.productTable = productTable;
        shop = new Shop(productTable);
        warehouse = new Warehouse(shop.getCatalog());
    }





    public void startSimulation(){
        System.out.println("= = = = S T A R T  = = = =");
        assignDaytoClient();
        clientsMakeOrders();
        System.out.println("Clients and days: " + clientDays);
        System.out.println("Their orders: " + orders);

    }

    private void assignDaytoClient(){
        DayChoice dayChoice = new DayChoice();
        // clients.forEach((c) -> clientDays.put(c, dayChoice.getDay(new Random(), PoissonLambda.INSTANCE.getLambdas().get(c.getPreference()))));
        clientDays = new Hashtable<>();
        for (Client client : clients) {
            int day = dayChoice.getDay(new Random(), PoissonLambda.INSTANCE.getLambdas().get(client.getPreference())); //uproscic wywolywanie metod, zeby dalo sie bez randoma i bez wskazywania lambdy
            clientDays.putIfAbsent(day,new ArrayList<>(List.of(client)));
            if(!clientDays.containsKey(day)){
                clientDays.get(day).add(client);
            }
        }
    }



    private void clientsMakeOrders(){
        AmountChoice amountChoice = new AmountChoice();
        clients.forEach((c) -> orders.add(new Order(shop, c, new Product(c.getPreference(),
                productTable.getProductTable().get(c.getPreference()), amountChoice.amountChoice(new Random(),  //todo uzupelnic cene juz w samym produkcie
                PoissonLambda.INSTANCE.getLambdas().get(c.getPreference()))))));
    }

    public Shop getShop() {
        return shop;
    }
    public void supplyShop(ShopSupplyTable shopSupplyTable){
        warehouse.supplyWarehouse(shopSupplyTable.getSupplyPolicy());
        System.out.println(warehouse.getInventory());
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    private Order makeOrder(Shop shop, Client client, int amount){
        Order order = new Order(shop, client, new Product(client.getPreference(), productTable.getProductTable().get(client.getPreference()), amount));
        return order;
    }

    public double getRating(Client client){
        //todo za pomoca streama i metody filter wyliczyc ocene dla przekazanego klienta
        return 0;
    }
    
    public int getYearDay(int monthDay){
        return monthDay*30 + monthDay;
    }


}
