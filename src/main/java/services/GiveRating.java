package services;

public class GiveRating {

    public static int giverating(int waittime) {
        if (waittime == 0) {
            return 5;
        }
        if (waittime > 0 && waittime < 7) {
            return 4;
        }
        if (waittime >= 7 && waittime < 17) {
            return 3;
        }
        if (waittime >= 17 && waittime < 31) {
            return 2;
        }
        if (waittime >= 31) {
            return 1;
        }
        return 0;
    }
}
