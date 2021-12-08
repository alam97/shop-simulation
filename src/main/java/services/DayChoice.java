package services;
import setvalues.PoissonLambda;

import java.util.Random;

public class DayChoice {

    public int getDay(Random random, int key){
        double lambda = PoissonLambda.INSTANCE.getLambdas().get(key);
        double day = -lambda*Math.log(1-random.nextDouble());
        return (int) day <= 0 || (int) day > 30 ? getDay(random, key) : (int)day;
    }
}
