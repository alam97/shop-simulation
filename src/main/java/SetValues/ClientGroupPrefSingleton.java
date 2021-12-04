package SetValues;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public enum ClientGroupPrefSingleton {
    INSTANCE;
    private final Hashtable<Integer, Integer> clientgroups;

    // private constructor
    ClientGroupPrefSingleton() {
        Hashtable<Integer, Integer> client_groups = new Hashtable<>();
        client_groups.put(20, 1);
        client_groups.put(30, 2);
        client_groups.put(40, 3);
        client_groups.put(50, 4);
        client_groups.put(60, 5);
        client_groups.put(70, 6);
        client_groups.put(80, 7);
        client_groups.put(90, 8);
        this.clientgroups = client_groups;
    }

    public Map<Integer, Integer> getClientgroups() {
        return Collections.unmodifiableMap(clientgroups);
    }
}
