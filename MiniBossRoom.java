import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniBossRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniBossRoom extends MyWorld
{
    MiniBoss miniBoss = new MiniBoss();
     public MiniBossRoom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        addObject(miniBoss,300,200);
    }
    public MiniBossRoom(Player player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.player = player;
        
    }
}
