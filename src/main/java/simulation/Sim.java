package simulation;

import model.*;
import services.*;
import setvalues.ProductTable;

import java.util.*;

public class Sim {

    private ClientFactory clientFactory;
    private List<Client> clients;
    private Map<Integer, List<Client>> clientDays = new Hashtable<>();
    private List<Shop> shops = new ArrayList<>();
    private Hashtable<Integer, List<Client>> clientsShop = new Hashtable<>();
    private List<SimShop> simulations = new ArrayList<>();
    public static int month = 1;
    public static int day = 1;
    public static int finalDay = 0;
    private boolean flag = false;

/*
    public Sim(int numOfClients, int duration, Shop shop) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        clients = clientFactory.getClients(numOfClients);
        finalday = duration;
        this.shop = shop;
    }
*/

    public Sim(int numOfClients, int duration, int[][] supplies) {
        clientFactory = new ClientFactory();
        clients = clientFactory.getClients(numOfClients);
        finalDay = duration;
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

    private void assignNewClients(){
        for (int i = 0; i < simulations.size() ; i++) {
            simulations.get(i).newClients(clientsShop.get(i+1));
        }
    }


    public void startSimulation() {
        System.out.println(">>>>>>>>>>>>>>> STARTING SIMULATION");
        System.out.println(getMonthDuration());
        dayZero();
        simulation();
    }

    private synchronized void simulation(){
        simulations.forEach(SimShop::startHandlingOrders);
        flag = month <= getMonthDuration();
        while (flag) {
            simulateOneMonth();
        }
    }

    public synchronized void simulateOneMonth() {
            if ( month > 1 ){
                assignDaytoClient();
                assignShoptoClient(false);
                assignNewClients();
    //            System.out.println("Klienci i sklep:" + clientsShop);
            }
            simulations.forEach( s -> s.getShop().supplyShop());
    //        System.out.println("Klienci i ich dzien: " + clientDays);
            while (getDayofmonth() < 31) {
                if (day == finalDay+1) {
                    System.out.println(">>>>>>>>>>>>>>> END OF SIMULATION");
                    flag = false;
                    return;
                }
                simulateOneDay();
                day++;
            }
            endOfMonth();
         //   simulations.forEach(s -> s.join());
            month++;
    }

   private void endOfMonth(){
        simulations.forEach(s -> s.addToBacklog());
        simulations.forEach(s -> s.getShop().getBacklog().loadInventory(s.getShop().getCatalog()));
        // raport na koniec miesiaca
        simulations.forEach(s -> System.out.println(s.getShop().getBacklog()));
    }

    public synchronized void simulateOneDay() {
        int lday = getDayofmonth();
        if(!clientDays.containsKey(lday)){
            //    System.out.println("Brak klientow: " + lday);
            return;
        }
        List<Client> clientsToday = clientDays.get(lday);
        for (Client client : clientsToday) {
            if(simulations.stream().noneMatch(s -> s.getClients() != null && s.getClients().contains(client))){
                continue;
            }
            // Tutaj klienci skladaja zamowienia
            simulations.stream().filter(s -> s.getClients() != null && s.getClients().contains(client))
                                .forEach(sim -> sim.queueOrder(new Order(sim.getShop(), client, lday)));
        }
    }

    public void dayZero() {
        assignDaytoClient();
        assignShoptoClient(true);
        System.out.println("Klienci i sklep:" + clientsShop);
        distributeThreads();
     //   simulations.forEach(SimShop::startHandlingOrders);
    }

    private void assignDaytoClient() {
        DayChoice dayChoice = new DayChoice();
        clientDays.clear();
        for (Client client : clients) {
            int day = dayChoice.getDay(new Random(), client.getPreference());
            clientDays.putIfAbsent(day, new ArrayList<>(List.of(client)));
            if (!clientDays.containsKey(day)) {
                clientDays.get(day).add(client);
            }
        }
    }

    private void assignShoptoClient(boolean isDayZero){
        ShopChoice shopChoice = new ShopChoice();
        clientsShop.clear();
        int id = 0;
        for (Client client: clients) {
            if (isDayZero) {
                id = shopChoice.chooseShop(shops.size());
            }
            else {
                List<Order> clientsOrders = new ArrayList<>();
                clientsOrders.addAll(simulations.get(0).ordersPerClient(client));
                clientsOrders.addAll(simulations.get(1).ordersPerClient(client));
                clientsOrders.addAll(simulations.get(2).ordersPerClient(client));
                id = shopChoice.chooseShop(client.getPreference(), simulations.get(0).getShop().meanStars(),
                                            simulations.get(1).getShop().meanStars(), simulations.get(2).getShop().meanStars(),
                                            clientsOrders);
            }
            if (clientsShop.containsKey(id)){
                clientsShop.get(id).add(client);
                continue;
            }
            clientsShop.putIfAbsent(id, new ArrayList<>(List.of(client)));
        }
    }

    public static int getDayofmonth() {
        int dayofmonth = day - 30 * (month - 1);
        return dayofmonth == 0 ? 1 : dayofmonth;
    }

    public static int getMonthDuration() {
        return (int)Math.ceil(finalDay /30)+1;
    }

}
