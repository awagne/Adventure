package src;

public class Rags extends Armor{

    public Rags(){
        this.setType("Rags");
    }
    
    public void Hit(Player player, int value){
        this.setDurability(50);
        player.setHealth(player.getHealth() - (value - 2));
    }
}
