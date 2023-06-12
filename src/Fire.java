package src;

public class Fire extends Item{
    public Fire(){
        this.setName("Fire");
    }

    public void useItem(Player player){
        player.setStatus("Fire");
    }
}
