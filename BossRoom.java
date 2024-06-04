import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BossRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossRoom extends World
{
    private GreenfootSound gameMusic;
    /**
     * Constructor for objects of class BossRoom.
     * 
     */
    public BossRoom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 650, 1); 
        gameMusic = new GreenfootSound("finalboss.mp3");
        started();
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        MiniBoss miniBoss = new MiniBoss();
        addObject(miniBoss,89,73);
        MiniBoss miniBoss2 = new MiniBoss();
        addObject(miniBoss2,858,80);
        MiniBoss miniBoss3 = new MiniBoss();
        addObject(miniBoss3,861,524);
        MiniBoss miniBoss4 = new MiniBoss();
        addObject(miniBoss4,89,518);
        Player player = new Player();
        addObject(player,477,422);
        if (new GreenfootSound("normalfight1.mp3").isPlaying()){
            new GreenfootSound("normalfight1.mp3").stop();
        }
        
    }
    
    public void act() {
        // Get a list of all MiniBoss objects in the world
        List<MiniBoss> miniBosses = getObjects(MiniBoss.class);
        // If there are no MiniBoss objects left
        if (miniBosses.isEmpty()) {
            // Switch to GameWinWorld
            stopped();
            stopped();
            Greenfoot.setWorld(new GameWinWorld());
        }
    }
    public void started(){
        gameMusic.playLoop();
    }
        public void stopped(){
        gameMusic.stop();
    }
}
