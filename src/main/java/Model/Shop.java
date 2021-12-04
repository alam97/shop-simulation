package Model;

import Interfaces.IHandleOrder;
import Interfaces.IPolicy;

import java.util.List;

public class Shop {

    private Double overallprofit;
    private Double stars;
    private Warehouse warehouse;
    private Backlog backlog = new Backlog();
    private IPolicy policy;
    private IHandleOrder handleOrder;
    private Catalog catalog;

    // Dependency injection ; we're injecting the interface policy that can have multiple implementations
    // as well as the way they handle the orders
    public Shop(IPolicy policy, IHandleOrder handleOrder) {
        this.policy = policy;
        this.handleOrder = handleOrder;
    }

    public Shop(IPolicy policy, IHandleOrder handleOrder, Catalog catalog) {
        this.policy = policy;
        this.handleOrder = handleOrder;
        this.catalog = catalog;
    }

    public List<Product> getCatalog() {
        return catalog.getCatalog();
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Double getOverallprofit() {
        return overallprofit;
    }

    public void setOverallprofit() {

    }
}
