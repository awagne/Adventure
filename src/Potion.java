package src;

public class Potion extends Item {

    public Potion(){
        this.setName("Potion");
    }

    public void useItem(Player player){
        int recovery = (int)(player.getHealth() * 1.25);

        if(player.getMaxHealth() > recovery){
            player.setHealth(recovery);
        }
        else{
            player.setHealth(player.getMaxHealth());
        }
    }
}
