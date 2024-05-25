import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWinWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWinWorld extends World
{

    /**
     * Constructor for objects of class GameWinWorld.
     * 
     */
    public GameWinWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(795, 533, 1);
        showText("You Won!", getWidth() / 2, getHeight() / 2 - 50);
        showText("Press 'R' to Play again or 'Q' to Quit!", getWidth() / 2, getHeight() / 2);
    }
    
        public void act() {
        if (Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new MainMenu());
        } else if (Greenfoot.isKeyDown("q")) {
            Greenfoot.stop();
        }
    }
}
