package simulation;

import interfaces.ISimulation;
import model.Shop;
import model.Warehouse;
import services.ClientFactory;
import setvalues.ClientGroupPref;
import setvalues.ProductTable;
import setvalues.ShopSupplyTable;

import java.util.Hashtable;

public class Sim implements ISimulation {

    private ClientFactory clientFactory;
    private Shop shop;
    private ProductTable productTable;
    private Warehouse warehouse;

    public Sim(int numOfClients, int duration, ProductTable productTable) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        shop = new Shop(productTable);
        warehouse = new Warehouse(shop.getCatalog());
    }

    public void startSimulation(){
        System.out.println("simulation");
    }
    public void getShop() {
      //  System.out.println(shop.getCatalog());
    }
    public void supplyShop(ShopSupplyTable shopSupplyTable){
       // warehouse.getInventory();
       // System.out.println(warehouse.getInventory());
        warehouse.supplyWarehouse(shopSupplyTable.getSupplyPolicy());
       // System.out.println(warehouse.getInventory());
    }


}
