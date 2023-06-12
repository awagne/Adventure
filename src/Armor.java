package src;

public class Armor {

    private String type = "";
    private int protection = 0;
    private int durability = 100;

    public Armor(){

    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public int getProtection(){
        return protection;
    }

    public int getDurability(){
        return durability;
    }

    public void setDurability(int value){
        durability -= value;
    }

    public void Hit(Player player, int value){
    }
    
}
