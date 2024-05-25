import greenfoot.*; 

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor 
{
    // instance variables - replace the example below with your own
    private int x;
    public int health = 5 + MyWorld.roomCounter;
    long lastHit = System.currentTimeMillis();
    /**
     * Constructor for objects of class Enemy
     */
    public Enemy()
    {
    }

    public void act() {
        moveAround();
        dealDamage();
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    /**
 * 
 */
public void moveAround()
{
    move(1);
    MyWorld world = (MyWorld) getWorld();
    Actor player = world.player;
    if (player != null) {
        if (isAtEdge()) {
            turn(180);
        }
        if (Greenfoot.getRandomNumber(10) >= 1) {
            turnTowards(player.getX(), player.getY());
        }
    }
}

public void dealDamage() {
    MyWorld world = (MyWorld) getWorld();
    Player player = (Player) world.player;
    if (player == null)
        return;
    long currentHit = System.currentTimeMillis();
    if (currentHit >= lastHit + 500) {//1000ms = 1s
        if (intersects(player) && Player.isDashing == false) {
            if (player.health > 0) {
                player.health -= 5;
                lastHit = System.currentTimeMillis();
            } else {
                if (player != null)
                {
                    world.player = null;
                    getWorld().removeObject(player);
                    Greenfoot.setWorld(new GameOverWorld());
                }
            }
        }
    }
}
}
