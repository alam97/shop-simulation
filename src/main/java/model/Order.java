package model;

import services.AmountChoice;
import services.GiveRating;

import java.util.Random;

public class Order {
    private Shop shop;
    private Client client;
    private Product product;
    private int dayOfOrder;
    private int dayOfCompletion = 0;
    private double markup;


    public Order(Shop shop, Client client, int dayOfOrder) {
        this.shop = shop;
        this.client = client;
        this.product = new Product(client.getPreference(), AmountChoice.amountChoice(new Random(), client.getPreference()));
        this.dayOfOrder = dayOfOrder;
    }

    public Shop getShop() {
        return shop;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public int getSatifactionRate() {
       return GiveRating.giverating(getOrderWaitTime());
    }

    private int getOrderWaitTime(){
        return dayOfCompletion-dayOfOrder;
    }



    public int getDayOfOrder() {
        return dayOfOrder;
    }

    public void setDayOfCompletion(int dayOfCompletion) {
        this.dayOfCompletion = dayOfCompletion;
    }

    public boolean isComplete() {
        return dayOfCompletion>0;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    //    product.
    }

    @Override
    public String toString() {
        return "Order{" +
                "shop=" + shop.getId() +
                ", client=" + client +
                ", product=" + product +
                ", day of order=" + dayOfOrder +
                ", realisation =" + dayOfCompletion +
                ", satifactionRate=" + getSatifactionRate() +
                ", complete=" + isComplete() +
                '}';
    }
}
