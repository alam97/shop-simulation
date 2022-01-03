package setvalues;

import java.util.Hashtable;

public class ClientGroupPref {

    public Hashtable<Integer, Integer> clientGroups = new Hashtable<>();

    public Hashtable<Integer, Integer> getClientgroups() {
        clientGroups.put(20, 1);
        clientGroups.put(30, 2);
        clientGroups.put(40, 3);
        clientGroups.put(50, 4);
        clientGroups.put(60, 5);
        clientGroups.put(70, 6);
        clientGroups.put(80, 7);
        clientGroups.put(90, 8);
        return clientGroups;
    }
}
