package setvalues;

import java.util.Hashtable;

public class ClientGroupPref {

    public Hashtable<Integer, Integer> getClientgroups() {
        Hashtable<Integer, Integer> client_groups = new Hashtable<>();
        client_groups.put(20, 1);
        client_groups.put(30, 2);
        client_groups.put(40, 3);
        client_groups.put(50, 4);
        client_groups.put(60, 5);
        client_groups.put(70, 6);
        client_groups.put(80, 7);
        client_groups.put(90, 8);
        return client_groups;
    }
}
