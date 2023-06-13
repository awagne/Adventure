package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
    
    @Test
    public void FreezeTest(){
        Player player = new Player();
        Enemy enemy = new Enemy();

        assertEquals(false, enemy.getFrozen());

        player.getItem("Freeze");
        player.useItem("Freeze");
        player.Attack(enemy);

        assertEquals(true, enemy.getFrozen());
    }

    @Test
    public void FireTest(){
        Player player = new Player();
        Enemy enemy = new Enemy();

        assertEquals(false, enemy.getBurning());

        player.getItem("Fire");
        player.useItem("Fire");
        player.Attack(enemy);

        assertEquals(true, enemy.getBurning());

    }

    @Test
    public void PotionTest(){
        Player player = new Player();
        Enemy enemy = new Enemy();

        assertEquals(100, player.getHealth());

        player.getItem("Potion");
        enemy.Attack(player);

        assertEquals(99, player.getHealth());

        player.useItem("Potion");
        assertEquals(100, player.getHealth());
    }
}
