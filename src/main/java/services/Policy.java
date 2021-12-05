package services;

import interfaces.IPolicy;

public class Policy implements IPolicy {

    public Boolean ifPolicy(Integer inWarehouse, Integer supplied){
        return inWarehouse > supplied;
    }
}
