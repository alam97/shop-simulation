package Services;

import Interfaces.IAmountChoice;
import java.util.Random;

public class AmountChoice implements IAmountChoice {

    public int amountChoice(Random random, double lambda){
        double l = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;
        do {
            k++;
            p *= random.nextDouble();
        }
        while (p > l);
        return k - 1 == 0 ? amountChoice(random, lambda) : k -1;
    }
}
