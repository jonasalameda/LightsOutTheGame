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

    /**
     * Constructor for objects of class BossRoom.
     * 
     */
    public BossRoom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 650, 1); 
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
    }
    
public void act() {
    // Get a list of all MiniBoss objects in the world
    List<MiniBoss> miniBosses = getObjects(MiniBoss.class);

    // If there are no MiniBoss objects left
    if (miniBosses.isEmpty()) {
        // Switch to GameWinWorld
        Greenfoot.setWorld(new GameWinWorld());
    }
}
}
