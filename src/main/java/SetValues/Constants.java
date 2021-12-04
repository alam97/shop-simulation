package SetValues;

import java.util.Hashtable;

public enum Constants {

    MARKUP(0.20),
    BUSINESS(1000d),
    CREDIT(0.002),
    NEW_MARKUP(0.002);

    private static final Hashtable<Constants, Double> BY_TYPE = new Hashtable<>();

    static {
        for (Constants c : values()) {
            BY_TYPE.put(c, c.amount);
        }
    }

    public final Double amount;

    private Constants(Double amount) {
        this.amount = amount;
    }

    public static Double getCostbyType(String type) {
        return BY_TYPE.get(type);
    }

}
