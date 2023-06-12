package src;

public class Freeze extends Item{
    public Freeze(){
        this.setName("Freeze");
    }

    public void useItem(Player player){
        player.setStatus("Freeze");
    }
}
