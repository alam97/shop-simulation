package model;

public class Order {
    private Shop shop;
    private Client client;
    private Product product;
    private int timeOfRealisation;
    private int satifactionRate = 0;
    private boolean complete = false;
    private double markup;

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

    public boolean isComplete() {
        return complete;
    }



    public void setMarkup(double markup) {
        this.markup = markup;
    //    product.
    }

    public void setCompletionStatus(boolean complete) {
        this.complete = complete;
    }

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
