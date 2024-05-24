import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
      public void act() {
        move(5); // Adjust the speed as needed
        checkCollision();
    }
    
    private void checkCollision() {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            // Reduce player's health
            ((Player) player).reduceHealth(10);
            // Remove the projectile from the world
            getWorld().removeObject(this);
        } else if (isAtEdge()) {
            // Remove the projectile if it goes off-screen
            getWorld().removeObject(this);
        }
    }
}
