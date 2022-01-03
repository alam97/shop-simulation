package setvalues;
import java.util.Hashtable;
import java.util.List;

public class ShopSupplyTable {

    private List<Integer> amounts;

    public ShopSupplyTable(List<Integer> amounts) {
        this.amounts = amounts;
    }

    public Hashtable<Integer, Integer> getSupplyPolicy() {
        Hashtable<Integer, Integer> supplyChain = new Hashtable<>();
        for (int i = 0; i < amounts.size(); i++){
            supplyChain.put(i+1, amounts.get(i));
        }
        return supplyChain;
    }

}
