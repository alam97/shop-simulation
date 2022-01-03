package services;

import model.Order;
import setvalues.PoissonLambda;

import java.util.*;

public class ShopChoice {

    public int chooseShop(int key, double meanShop1, double meanShop2, double meanShop3, List<Order> orders){
        Random random = new Random();
        // wziete z wyboru dnia - im starszy czlowiek, tym mniej kieruje sie ocenami sklepu/tym mniej sklonny jest do zmiany sklepu
        double lambda = PoissonLambda.INSTANCE.getLambdas().get(key);
        double ageFactor = -lambda*Math.log(1-random.nextDouble());
        while (ageFactor < 0 ){
            ageFactor = -lambda*Math.log(1-random.nextDouble());
        }
        // zbieram srednia ocen klienta dla kazdego sklepu, filtrujac liste jego zamowien przez id sklepu
        double forShop1 = orders.stream().filter( o -> o.getShop().getId() == 1).mapToInt(Order::getSatifactionRate).average().orElse(-1);
        double forShop2 = orders.stream().filter( o -> o.getShop().getId() == 2).mapToInt(Order::getSatifactionRate).average().orElse(-1);
        double forShop3 = orders.stream().filter( o -> o.getShop().getId() == 3).mapToInt(Order::getSatifactionRate).average().orElse(-1);
        // stosunek sredniej od klienta do sredniej ogolnej sklepu
        double prob1 = forShop1/meanShop1;
        double prob2 = forShop2/meanShop2;
        double prob3 = forShop3/meanShop3;
        // mnoze przez wiek i wybieram max
        Hashtable<Integer, Double> set = new Hashtable<>();
        set.put(1, prob1*ageFactor);
        set.put(2, prob2*ageFactor);
        set.put(3, prob3*ageFactor);
        int chosenShop = -1;
        double highestChance = Collections.max(set.values());
        for (Map.Entry<Integer, Double> entry : set.entrySet()) {
            if (entry.getValue() == highestChance) {
                chosenShop = entry.getKey();
                break;
            }
            }
        return chosenShop;
    }

    public int chooseShop(int numOfShops){
        int shop = new Random().nextInt(numOfShops+1);
        return shop != 0 ? shop : chooseShop(numOfShops);
    }

}
