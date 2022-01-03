package model;

import setvalues.ProductTable;

public class Product {

    private int id;
    private double price;
    private int amount = 0;
    private ProductTable productTable = new ProductTable();

    public Product(int id) {
        this.id = id;
        this.price = productTable.getProductTable().get(id);
    }

    public Product(int id, int amount) {
        this.id = id;
        this.price = productTable.getProductTable().get(id);
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPricewithMarkup(double markup) { price = price*markup+price; }

    public double getTotalPrice(){
        return price * amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "Product " +  id + System.lineSeparator() +
                "Price: " + price + System.lineSeparator() +
                "Amount:" + amount  + System.lineSeparator() + ' ';
    }
}
