package src;

public class ItemPair {
    private Item key;
    private int val;

    public ItemPair(Item key, int val){
        this.key = key;
        this.val = val;
    }

    public Item getKey(){
        return key;
    }

    public int getValue(){
        return val;
    }

    public void setValue(int val){
        this.val = val;
    }
}
