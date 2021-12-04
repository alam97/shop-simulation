package Services;

import Interfaces.IPolicy;
import Model.Warehouse;

import java.util.List;

public class Policy implements IPolicy {

    private double new_markup;

    public Policy(double new_markup) {
        this.new_markup = new_markup;
    }

    public Boolean ifPolicy(Integer inWarehouse, Integer supplied){
        return inWarehouse > supplied ? true : false;
    }

    public Double applyPolicy(Boolean valid, Double price){
        return valid ? this.new_markup*price+price : price;
    }
}
