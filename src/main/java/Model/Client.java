package Model;
/* Single Class Responsibility:
    Model.Client is just responsible for itself, the entity
 */

import java.util.Random;

public class Client {
    private int age;
    // preference = the id of the product
    private int preference;

    public Client() {
        this.age = generateAge();
    }

    public Client(int age) {
        this.age = age;
    }

    public int generateAge() {
        Random r = new Random();
        double myG = r.nextGaussian()*20+65;
        if (myG < 20 || myG > 100) {
            generateAge();
        }
            return  (int)myG;
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

}
