package Simulation;

import Interfaces.IDayChoice;
import Interfaces.IHandleOrder;
import Interfaces.IPolicy;
import Interfaces.ISimulation;
import Model.*;
import Services.ClientFactory;
import Services.DayChoice;
import Services.HandleOrder;
import Services.Policy;
import SetValues.ClientGroupPrefSingleton;
import SetValues.Constants;
import SetValues.ProductTableSingleton;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Sim implements ISimulation {

    private int simulation_length;
    private int day = 0;
    private Catalog catalog = new Catalog((Hashtable<Integer, Double>) ProductTableSingleton.INSTANCE.getProduct_table());
    private Warehouse warehouse = new Warehouse();
    private IPolicy policy = new Policy(Constants.getCostbyType("NEW_MARKUP"));
    private Supply supply = new Supply();
    private IHandleOrder handleOrder = new HandleOrder(warehouse);
    private ClientFactory clientFactory = new ClientFactory((Hashtable<Integer, Integer>) ClientGroupPrefSingleton.INSTANCE.getClientgroups());
    private List<Client> clients = new ArrayList<>();
    private IDayChoice dayChoice = new DayChoice();
    private Shop shop = new Shop(policy, handleOrder);

    public Sim(int simulation_length, int numberOfclients) {
        this.simulation_length = simulation_length;
        this.clientFactory.generateClients(numberOfclients);
    }

    // PSEUDO KOD, Jak rozumiem zadanie:
    /*
    * IF DAY O =
    * */

}
