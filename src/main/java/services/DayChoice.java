package services;

import interfaces.IDayChoice;

import java.util.Random;

public class DayChoice implements IDayChoice {
    public Double getDay(Random random, double lamda){
        return -lamda*Math.log(1-random.nextDouble());
    }
}
