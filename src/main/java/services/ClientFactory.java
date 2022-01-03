package services;

import model.Client;
import setvalues.ClientGroupPref;

import java.util.*;

public class ClientFactory {
    private ClientGroupPref clientGroupPref = new ClientGroupPref();
    public ClientFactory() {}

    public List<Client> getClients(int num) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < num; i++){
            clients.add(i, new Client());
        }
        assignGroup(clients);
        return Collections.unmodifiableList(clients);
    }


    private void assignGroup(List<Client> clients){
        Hashtable<Integer, Integer> clientPref = clientGroupPref.getClientgroups();
        clients.forEach((c) -> {
            int group = (int)Math.round(c.getAge()/10.0) * 10;
            if (group >= 100){
                group = 90;
            }
            System.out.println(group);
            c.setPreference(clientPref.get(group));
        });
    }

}

