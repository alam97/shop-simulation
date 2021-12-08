package services;
public class Policy {

    public Boolean ifPolicy(Integer inWarehouse, Integer supplied){
        return inWarehouse > supplied;
    }
}
