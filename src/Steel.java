package src;

public class Steel extends Armor{
    
    public Steel(){
        this.setType("Steel");
    }

    public void Hit(Player player, int value){
        this.setDurability(20);
        player.setHealth(player.getHealth() - (value - 10));
    }
}
