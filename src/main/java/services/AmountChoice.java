package services;

import setvalues.PoissonLambda;

import java.util.Random;

public class AmountChoice {

    public static int amountChoice(Random random, int key){
        double lambda = PoissonLambda.INSTANCE.getLambdas().get(key);
        double l = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;
        do {
            k++;
            p *= random.nextDouble();
        }
        while (p > l);
        return k - 1 <= 0 ? amountChoice(random, key) : k - 1;
    }
}
