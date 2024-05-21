import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (jomnas) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Player player = new Player();
    long lastAdded = System.currentTimeMillis();
    public int counter = 5;
    public boolean canLeave = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);

        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(player,300,400);

        Enemy enemy = new Enemy();
        addObject(enemy,Greenfoot.getRandomNumber(400),Greenfoot.getRandomNumber(200));
        Enemy enemy1 = new Enemy();
        addObject(enemy1,Greenfoot.getRandomNumber(400),Greenfoot.getRandomNumber(200));
        Enemy enemy2 = new Enemy();
        addObject(enemy2,Greenfoot.getRandomNumber(400),Greenfoot.getRandomNumber(200));
        Enemy enemy3 = new Enemy();
        addObject(enemy3,Greenfoot.getRandomNumber(400),Greenfoot.getRandomNumber(200));
        
    }
    public void spawnMoreEnemies()
    {
        long curTime  = System.currentTimeMillis();
    
        if (curTime >= lastAdded + 5000) {//5000ms = 5s
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(new Enemy(),getWidth(),y);
        lastAdded  = curTime;
    
        }
    }
    public void act() {
        spawnMoreEnemies();
        if (getObjects(Enemy.class).size() == 0)
            Greenfoot.setWorld(new GameWin());
        
    }
    
}
