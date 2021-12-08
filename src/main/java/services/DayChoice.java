package services;
import java.util.Random;

public class DayChoice {
    public int getDay(Random random, double lamda){
        double day = -lamda*Math.log(1-random.nextDouble());
        return (int) day <= 0 || (int) day > 30 ? getDay(random, lamda) : (int)day;
    }
}
