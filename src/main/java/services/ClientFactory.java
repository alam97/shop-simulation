package services;

import interfaces.IClientFactory;
import model.Client;
import setvalues.ClientGroupPref;

import java.util.*;

public class ClientFactory implements IClientFactory {
    private ClientGroupPref clientGroupPref;

    public ClientFactory(ClientGroupPref clientGroupPref) {
        this.clientGroupPref = clientGroupPref;
    }

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
            int group = ((c.getAge()%100)/10)*10;
            c.setPreference(clientPref.get(group));
        });
    }

}

