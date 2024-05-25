import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangedEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangedEnemy extends Actor
{
    /**
     * Act - do whatever the RangedEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x;
    public int health = 5;
    long lastHit = System.currentTimeMillis();
    private int shootDelay = 350; // Adjust the delay
    private int shootTimer = 0;
    /**
     * Act - do whatever the MiniBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        shootAtPlayer();
    }
    

    private void shootAtPlayer() {
        if (shootTimer <= 0) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            // Optionally set the direction towards the player
            Actor player = (Actor) getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(), player.getY());
            projectile.setRotation(getRotation());
            shootTimer = shootDelay;
        } else {
            shootTimer--;
        }
    }
}
