package src;

public class Armor {

    private String type = "";
    private int protection = 0;
    private int durability = 100;
    private int maxDurability = 100;

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

    public void setProtection(int value){
        protection = value;
    }

    public int getDurability(){
        return durability;
    }

    public int getMaxDurability(){
        return maxDurability;
    }

    public void setDurability(int value){
        durability = value;
        maxDurability = value;
    }

    
    public void subDurability(int value){
        durability -= value;
    }

    public void Hit(Player player, int value){
        this.subDurability(1);
        player.setHealth(player.getHealth() - (value - protection));
    }
    
}
