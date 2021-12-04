package Services;

import Interfaces.IClientFactory;
import Model.Client;

import java.util.*;

public class ClientFactory implements IClientFactory {
    private List<Client> clients = new ArrayList<>();
    private Hashtable<Integer, Integer> client_pref;

    public ClientFactory(Hashtable<Integer, Integer> client_pref) {
        this.client_pref = client_pref;
    }

    public void generateClients(int num){
        for (int i = 0; i < num + 1; i++){
            this.clients.add(i, new Client());
        }
    }

    public void assignGroup(){

        this.clients.forEach((c) -> {
            if (c.getAge() < client_pref.get(1)){
                c.setPreference(1);
            }
            else if (c.getAge() < 40){
                c.setPreference(this.client_pref.get(30));
            }
            else if (c.getAge() < 50){
                c.setPreference(this.client_pref.get(40));
            }
            else if (c.getAge() < 60){
                c.setPreference(this.client_pref.get(50));
            }
            else if (c.getAge() < 70){
                c.setPreference(this.client_pref.get(60));
            }
            else if (c.getAge() < 80){
                c.setPreference(this.client_pref.get(70));
            }
            else if (c.getAge() < 90){
                c.setPreference(this.client_pref.get(80));
            }
            else if (c.getAge() < 100){
                c.setPreference(this.client_pref.get(90));
            }
        });
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }
}

