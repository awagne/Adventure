package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnemyTest {
    
    @Test
    public void AttackTest(){
        Player player = new Player();
        Enemy enemy = new Enemy();

        enemy.Attack(player);
        assertEquals(99, player.getHealth());
    }
}
