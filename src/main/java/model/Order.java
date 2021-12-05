package model;

public class Order {
    private Shop shop;
    private Client client;
    private Product product;
    private int time_of_realisation;
    private int satifaction_rate;
    private int amount;
    private Boolean complete = false;

    public Order(Shop shop, Client client, Product product, int timeOfRealisation, int amount) {
        this.shop = shop;
        this.client = client;
        this.product = product;
        this.time_of_realisation = timeOfRealisation;
        this.amount = amount;
    }

    public void setSatifaction_rate(int satifaction_rate) {
        this.satifaction_rate = satifaction_rate;
    }

    public int getSatifaction_rate() {
        return satifaction_rate;
    }

    public Product getProduct() {
        return product;
    }

    public Shop getShop() {
        return shop;
    }

    public Client getClient() {
        return client;
    }

    public int getTime_of_realisation() {
        return time_of_realisation;
    }

    public int getAmount() {
        return amount;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}
