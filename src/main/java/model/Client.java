package model;
/* Single Class Responsibility:
    Model.Client is just responsible for itself, the entity
 */

import java.util.Random;

public class Client {
    private int age;
    // preference = the id of the product
    private int preference;

    public Client() {
        age = generateAge();
    }

    public int generateAge() {
        Random r = new Random();
        double myG = r.nextGaussian()*20+65;
        int age = (int)myG;
        return age < 20 || age > 100 ? generateAge() : age;
    }

    public int getAge() {
        return age;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "Client{" +
                "age=" + age +
                ", preference=" + preference +
                '}';
    }
}
