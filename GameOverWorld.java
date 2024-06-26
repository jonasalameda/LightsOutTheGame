import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{
    private GreenfootSound gameMusic;
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        gameMusic = new GreenfootSound("gameover.mp3");
        MyWorld.roomCounter = 0;
        showText("Game Over", getWidth() / 2, getHeight() / 2 - 50);
        showText("Press 'R' to Restart or 'Q' to Quit", getWidth() / 2, getHeight() / 2);
    }
    public void act() {
        if (Greenfoot.isKeyDown("r")) {
            stopped();
            stopped();
            new MyWorld().started();
            Greenfoot.setWorld(new MyWorld());
        } else if (Greenfoot.isKeyDown("q")) {
            stopped();
            Greenfoot.stop();
        }
    }
        public void started(){
        gameMusic.playLoop();
    }
        public void stopped(){
        gameMusic.stop();
    }
}
