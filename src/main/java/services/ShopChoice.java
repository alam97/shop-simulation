package services;

import model.Order;
import setvalues.PoissonLambda;

import java.util.List;
import java.util.Random;

public class ShopChoice {

    public void chooseShop(int key, double meanShop1, double meanShop2, double meanShop3, List<Order> orders, int price){
        Random random = new Random();
        // wziete z wyboru dnia - im starszy czlowiek, tym mniej kieruje sie ocenami sklepu/tym mniej sklonny jest do zmiany sklepu
        double lambda = PoissonLambda.INSTANCE.getLambdas().get(key);
        double ageFactor = -lambda*Math.log(1-random.nextDouble());
        while (ageFactor < 0 ){
            ageFactor = -lambda*Math.log(1-random.nextDouble());
        }
        // zbieram srednia ocen klienta dla kazdego sklepu, filtrujac liste jego zamowien przez id sklepu
        double forShop1 = orders.stream().filter( o -> o.getShop().getId() == 1).mapToInt(o-> o.getSatifactionRate()).average().orElse(-1);
        double forShop2 = orders.stream().filter( o -> o.getShop().getId() == 2).mapToInt(o -> o.getSatifactionRate()).average().orElse(-1);
        double forShop3 = orders.stream().filter( o -> o.getShop().getId() == 3).mapToInt(o -> o.getSatifactionRate()).average().orElse(-1);
        // stosunek
        double prob1 = forShop1/meanShop1;
        double prob2 = forShop2/meanShop2;
        double prob3 = forShop3/meanShop3;
    }

    public int chooseShop(){
        int shop = new Random().nextInt(4);
        return shop != 0 ? shop : chooseShop();
    }

}
