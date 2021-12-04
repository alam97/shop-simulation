package Services;

import Model.Product;
import Model.Shop;

import java.util.Hashtable;

public class GenerateReport {

    private double business_cost;
    private int clients_handled;
    private int shop_stars;
    private Hashtable<Product, Integer> warehouse_state = new Hashtable<>();

    public GenerateReport(double business_cost, int clients_handled, Hashtable<Product, Integer> warehouse_state) {
        this.business_cost = business_cost;
        this.clients_handled = clients_handled;
        this.warehouse_state = warehouse_state;
    }

    public void generateReport(){



    }

}
