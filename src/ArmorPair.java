package src;

public class ArmorPair {
    private Armor key;
    private int val;

    public ArmorPair(Armor key, int val){
        this.key = key;
        this.val = val;
    }

    public Armor getKey(){
        return key;
    }

    public int getValue(){
        return val;
    }

    public void setValue(int val){
        this.val = val;
    }

    public void addValue(int val){
        this.val += val;
    }
}
