package simulation;

import model.*;
import services.*;
import setvalues.ClientGroupPref;
import setvalues.ProductTable;

import java.util.*;

public class Sim {

    private ClientFactory clientFactory;
    private Shop shop;
    private List<Client> clients;
    private Map<Integer, List<Client>> clientDays;
    private List<Shop> shops = new ArrayList<>();
    private Hashtable<Integer, List<Client>> clientsShop;
    private List<SimShop> simulations = new ArrayList<>();
    // if day % 30 == 0 then month++
    // dlaczego statyczne? zeby byly globalnie dostepne
    public static int month = 1;
    // global days
    public static int day = 1;
    public static int finalday = 0;

    public Sim(int numOfClients, int duration, Shop shop) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        clients = clientFactory.getClients(numOfClients);
        finalday = duration;
        this.shop = shop;
    }

    public Sim(int numOfClients, int duration, int[][] supplies) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        clients = clientFactory.getClients(numOfClients);
        finalday = duration;
        createShops(supplies);
        System.out.println(shops);
    }

    private void createShops(int[][] supplies){
        for (int[] supply : supplies) {
            shops.add(new Shop(new ProductTable(), supply));
        }
    }

    private void distributeThreads(){
        for (int i = 0; i < shops.size(); i++) {
            simulations.add(new SimShop(shops.get(i), clientsShop.get(i+1)));
        }
    }

    public void startSimulation() {
        dayZero();
        simulateOneMonth();
    }

    public void simulateOneMonth() {
        shops.forEach(Shop::supplyShop);
        System.out.println(clientDays);
        while (getDayofmonth() < 31) {
            simulateOneDay();
            day++;
        }
        simulations.forEach(s -> System.out.println(s.toString()));
    //    simulations.forEach(s -> s.stopSimulation());
    }

    public void dayZero() {
        assignDaytoClient();
        assignShoptoClient();
        System.out.println("Klienci i sklep:" + clientsShop);
        distributeThreads();
        System.out.println(simulations);
        simulations.forEach(SimShop::startHandlingOrders);
       // shops.forEach( s -> s.startHandlingOrders());
       // shop.startHandlingOrders();
    }

    public void simulateOneDay() {
        int lday = getDayofmonth();
        if(!clientDays.containsKey(lday)){
            System.out.println("Brak klientow: " + lday);
            return;
        }
        List<Client> clientsToday = clientDays.get(lday);
        //System.out.println("================ About to start ordering for shops");
    //    System.out.println("==== Czy shopy w simie maja klientow??? ");
     //   simulations.forEach(s -> System.out.println(s.getShop() + " "  + s.getClients()));
     //   System.out.println("Czy w dzisiejszym dniu ktos ma klienta? ");
        for (Client client : clientsToday) {
            if(simulations.stream().noneMatch(s -> s.getClients() != null && s.getClients().contains(client))){
                continue;
            }
            simulations.stream().filter(s -> s.getClients() != null && s.getClients().contains(client)).forEach(sim -> sim.queueOrder(new Order(sim.getShop(), client, lday)));
        }
     //   clientsToday.forEach(c-> shop.queueOrder(new Order(shop, c, lday)));
        // wybor sklepu
    }

    private void assignDaytoClient() {
        DayChoice dayChoice = new DayChoice();
        clientDays = new Hashtable<>();
        for (Client client : clients) {
            int day = dayChoice.getDay(new Random(), client.getPreference());
            clientDays.putIfAbsent(day, new ArrayList<>(List.of(client)));
            if (!clientDays.containsKey(day)) {
                clientDays.get(day).add(client);
            }
        }
    }

    private void assignShoptoClient(){
        ShopChoice shopChoice = new ShopChoice();
        clientsShop = new Hashtable<>();
        System.out.println(clients);
        for (Client client: clients) {
            int id = shopChoice.chooseShop(shops.size());
            if (clientsShop.containsKey(id)){
                clientsShop.get(id).add(client);
                continue;
            }
            clientsShop.putIfAbsent(id, new ArrayList<>(List.of(client)));
        }
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public static int getDayofmonth() {
        int dayofmonth = day - 30 * (month - 1);
        return dayofmonth == 0 ? 1 : dayofmonth;
    }

}
