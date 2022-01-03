import simulation.Sim;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args){

        int numOfClient = 1000;
        int duration = 365;

        int[][] supplies = {IntStream.of(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000).toArray(),
                            IntStream.of(100, 200, 300, 400, 500, 600, 700, 800).toArray(),
                            IntStream.of(10, 20, 30, 40, 50, 60, 70, 80).toArray()};

        Sim sim1 = new Sim(numOfClient, duration, supplies);
        sim1.startSimulation();
    }
}
