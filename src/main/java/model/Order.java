package model;

public class Order {
    private Shop shop;
    private Client client;
    private Product product;
    private int timeOfRealisation;
    private int satifactionRate = 0;
    private Boolean complete = false;

    public Order(Shop shop, Client client, Product product) {
        this.shop = shop;
        this.client = client;
        this.product = product;
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
        return satifactionRate;
    }

    public void setSatifactionRate(int satifactionRate) {
        this.satifactionRate = satifactionRate;
    }

    public int getTimeOfRealisation() {
        return timeOfRealisation;
    }

    public void setTimeOfRealisation(int timeOfRealisation) {
        this.timeOfRealisation = timeOfRealisation;
    }

    public Boolean isComplete() {
        return complete;
    }

    public void setCompletionStatus(Boolean complete) {
        this.complete = complete;
    }

//    public int getTimeOfRealization(int currentDay){
//        return currentDay - dayOfRealization;
//    }

    @Override
    public String toString() {
        return "Order{" +
                "shop=" + shop +
                ", client=" + client +
                ", product=" + product +
                ", timeOfRealisation=" + timeOfRealisation +
                ", satifactionRate=" + satifactionRate +
                ", complete=" + complete +
                '}';
    }
}
