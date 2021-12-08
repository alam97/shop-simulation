package model;

public class Product {

    private int id;
    private double price;
    private int amount = 0;

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public Product(int id, double price, int amount) {
        this.id = id;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
