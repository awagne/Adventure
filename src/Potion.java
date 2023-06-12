package src;

public class Potion extends Item {

    public Potion(){
        this.setName("Potion");
    }

    public void useItem(Player player){
        player.setHealth((int)(player.getHealth() * 1.25));
    }
}
