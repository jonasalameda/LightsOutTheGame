import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VanierLogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VanierLogo extends World
{
    long timeMenuCreation = System.currentTimeMillis();
    /**
     * Constructor for objects of class VanierLogo.
     * 
     */
    public VanierLogo()
    {    
        // Create a new world with 900x473 cells with a cell size of 1x1 pixels.
        super(900, 473, 1); 
    }
    
    public void act() {
        if (System.currentTimeMillis() >= (timeMenuCreation + (5 * 1000)))
        {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
