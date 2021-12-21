package simulation;

import model.Client;
import model.Order;
import model.Product;
import model.Shop;
import services.AmountChoice;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SimShop {

    private Shop shop;
    private List<Client> clients;
    private List<Order> orders = new LinkedList<>();

    // na poczatku kazdy sklep dostaje swoja liste klientow
    public SimShop(Shop shop, List<Client> clients) {
        this.shop = shop;
        this.clients = clients;
    }

    // clients make orders
    private void clientsMakeOrders(){
        AmountChoice amountChoice = new AmountChoice();
        clients.forEach((c) -> orders.add(new Order(shop, c, Sim.getDayofmonth())));
    }
    // handle orders
//    public void handleOrders(){
//        orders.stream().filter( o -> !o.isComplete()).forEach( o -> shop.handleOrder(o));
//    }

    // giverating
}
