package setvalues;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public enum PoissonLambda {

    INSTANCE;
    private Hashtable<Integer, Double> lambdas;

    private PoissonLambda(){
        Hashtable<Integer, Double> l = new Hashtable<>();
        l.put(1, 15d);
        l.put(2, 13.43);
        l.put(3, 11.86);
        l.put(4, 10.29);
        l.put(5, 8.71);
        l.put(6, 7.14);
        l.put(7, 5.57);
        l.put(8, 4d);

        this.lambdas = l;
    }

    public Map<Integer, Double> getLambdas() { return Collections.unmodifiableMap(lambdas);}

}
