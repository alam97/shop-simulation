package services;
public class Policy {

    public boolean ifPolicy(int inWarehouse, int supplied){
        return inWarehouse > supplied;
    }
}
