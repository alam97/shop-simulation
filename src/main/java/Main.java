import model.Shop;
import services.AmountChoice;
import services.DayChoice;
import setvalues.PoissonLambda;
import setvalues.ProductTable;
import setvalues.ShopSupplyTable;
import simulation.Sim;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args){

        int numOfClient = 4;
        int duration = 50;
        ProductTable productTable = new ProductTable();

/*        int[] supply3 = IntStream.of(10, 20, 30, 40, 50, 60, 70, 80).toArray();
        int[] supply2 = IntStream.of(100, 200, 300, 400, 500, 600, 700, 800).toArray();
        int[] supply1 = IntStream.of(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000).toArray();
*/

        int[][] supplies = {IntStream.of(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000).toArray(), IntStream.of(100, 200, 300, 400, 500, 600, 700, 800).toArray(), IntStream.of(10, 20, 30, 40, 50, 60, 70, 80).toArray()};

      //  Shop shop1 = new Shop(productTable, supplies[0]);
      //  Shop shop2 = new Shop(productTable, supplies[1]);
      //  Shop shop3 = new Shop(productTable, supplies[2]);

       // Sim sim = new Sim(numOfClient, duration, shop1);
      //  sim.startSimulation();

        Sim sim1 = new Sim(numOfClient, duration, supplies);
        sim1.startSimulation();

      //  System.out.println(sim.getRating(sim.getClients().get(0)));
    }
}
