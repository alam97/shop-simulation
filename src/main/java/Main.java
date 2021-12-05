import setvalues.ProductTable;
import simulation.Sim;

public class Main {

    public static void main(String[] args){

        int numOfClient = 4;
        int duration = 365;
        ProductTable productTable = new ProductTable();
        Sim sim = new Sim(numOfClient, duration, productTable);
        sim.startSimulation();
        sim.getShop();
    }
}
