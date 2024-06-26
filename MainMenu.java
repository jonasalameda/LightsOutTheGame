import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    private GreenfootSound gameMusic;
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        gameMusic = new GreenfootSound("menusong.mp3");
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        StartButton startButton = new StartButton();
        addObject(startButton,419,335);
        MyWorld.roomCounter = 0;
    }
        public void started(){
        gameMusic.playLoop();
    }
        public void stopped(){
        gameMusic.stop();
    }
}
