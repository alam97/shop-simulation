package simulation;
import model.*;
import services.*;
import setvalues.ClientGroupPref;

import java.util.*;
import java.util.stream.Collectors;

public class Sim {

    private ClientFactory clientFactory;
    private Shop shop;
    private Warehouse warehouse;
    private List<Client> clients;
    private Map<Integer,List<Client>> clientDays;
    private List<Order> orders = new LinkedList<>();
    // if day % 30 == 0 then month++
    private int month = 1;
    // global days
    private int day = 1;

    public Sim(int numOfClients, int duration, Shop shop) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        clients = clientFactory.getClients(numOfClients);
        this.shop = shop;
    }


    public void startSimulation(){
        dayZero();
        simulateOneMonth();
    }

    public void dayZero(){
        assignDaytoClient();
        clientsMakeOrders();
    }

    public void simulateOneDay(){
        int lday = getDayofmonth();
        List<Client> clientsToday = clientDays.get(lday);
        // wybor sklepu

    }

    //todo przegladac klientow i wywolywac dla kazdego handle order
    //todo give rating zliczajac getdayofmonth - day z client day (pytanie: jak dostac sie do tego klienta w hashtable<dzien, lisa klientow>?
    // rozdzielic symulacje na 3 watki
    // na ten moment zrobmy shopchoice uniformowy

    public void checkforHandled(){
        if (orders.stream().noneMatch( o -> o.isComplete())){
            return;
        }
        else {
            GiveRating rating = new GiveRating();
          //  orders.stream().filter( o -> o.isComplete() == true).forEach( o -> o.setSatifactionRate(rating(getDayofmonth() - clientDays.)));
        }
    }

    public void handleOrders(){
        orders.stream().filter( o -> !o.isComplete()).forEach( o -> shop.handleOrder(o));
    }

    public void simulateOneMonth(){
        shop.supplyShop();
        while (day < 31){
            simulateOneDay();
            day++;
        }
        System.out.println(shop);
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
       return orders.stream()
                .filter(order -> order.getClient().equals(client))
                .mapToInt(Order::getSatifactionRate)
                .average() // zwraca optional
                .orElse(-1);
    }
    
    public int getDayofmonth(){
        int dayofmonth = day - 30*(month-1);
        return dayofmonth == 0 ? 1 : dayofmonth;
    }

}
