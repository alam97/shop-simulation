package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backlog {

    private List<Supply> supplybacklog = new ArrayList<>();
    private List<Order> ordersbacklog = new ArrayList<>();

    public void addToBacklog(Supply supply){
        this.supplybacklog.add(supply);
    }

    public void addToBacklog(List<Order> processed){ this.ordersbacklog.addAll(processed);}

    public void clearBacklog(){
        this.supplybacklog.clear();
    }

    public List<Supply> getSupplybacklog(){
        return Collections.unmodifiableList(supplybacklog);
    }

    public List<Order> getOrdersbacklog() { return Collections.unmodifiableList(ordersbacklog);}

}
