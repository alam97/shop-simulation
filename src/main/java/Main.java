import services.AmountChoice;
import services.DayChoice;
import setvalues.PoissonLambda;
import setvalues.ProductTable;
import setvalues.ShopSupplyTable;
import simulation.Sim;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        int numOfClient = 4;
        int duration = 365;
        ProductTable productTable = new ProductTable();
        Sim sim = new Sim(numOfClient, duration, productTable);
        sim.startSimulation();
        List<Integer> supply = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
        ShopSupplyTable shopSupplyTable = new ShopSupplyTable(supply);
        sim.supplyShop(shopSupplyTable);
    }
}
