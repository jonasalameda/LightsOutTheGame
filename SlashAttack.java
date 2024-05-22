import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlashAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlashAttack extends Actor
{
    long initialTime = System.currentTimeMillis();
    public SlashAttack()
    {
    }
    public SlashAttack(int rotation)
    {
        turn(rotation);
    }
    /**
     * Act - do whatever the SlashAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        long currentHit = System.currentTimeMillis();
        if(currentHit > initialTime + 600)
        {
            if (getWorld() != null)
            {
                getWorld().removeObject(this);
            }
        }
        else 
        {
            if(currentHit > initialTime + 200){
                turn(2);
                checkEnemyCollision();
            }
            
        }
    }

        public void checkEnemyCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) 
        {
           processEnemyHit((Enemy) enemy);
        }
    }
    public void processEnemyHit( Enemy enemy)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (enemy.health != 0) {
            enemy.health -= 1;
            Greenfoot.delay(1);
        } else {
            getWorld().removeObject(enemy);
        }
    }
}
