package simulation;

import interfaces.ISimulation;
import model.Shop;
import services.ClientFactory;
import setvalues.ClientGroupPref;
import setvalues.ProductTable;

public class Sim implements ISimulation {

  /*  private int simulation_length;
    private int day = 0;
    //private Catalog catalog = new Catalog((Hashtable<Integer, Double>) ProductTableSingleton.INSTANCE.getProduct_table());
    private Warehouse warehouse = new Warehouse();
    private IPolicy policy = new Policy(Constants.getCostbyType("NEW_MARKUP"));
    private Supply supply = new Supply();
    private IHandleOrder handleOrder = new HandleOrder(warehouse);
    private List<Client> clients = new ArrayList<>();
    private IDayChoice dayChoice = new DayChoice();
    private Shop shop = new Shop(policy, handleOrder);*/

    private ClientFactory clientFactory;
    private Shop shop;
    private ProductTable productTable;

    public Sim(int numOfClients, int duration, ProductTable productTable) {
        clientFactory = new ClientFactory(new ClientGroupPref());
        shop = new Shop(productTable);
    }

    public void startSimulation(){
        System.out.println("simulation");
    }
    public void getShop() {
        System.out.println(shop.getCatalog());
    }


}
