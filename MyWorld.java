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
    public static int roomCounter = 0;
    public static int enemyCounter = 5 + roomCounter;
    int currentEnemies = 0;
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
        addObject(player,300,500);
        enemyCounter = 5 + roomCounter;
    }
    public void spawnMoreEnemies()
    {
        long curTime  = System.currentTimeMillis();
        int randNum = Greenfoot.getRandomNumber(2);
        if (curTime >= lastAdded + 500 && currentEnemies < enemyCounter) {//5000ms = 5s
            int y = Greenfoot.getRandomNumber(getHeight());
            int x = Greenfoot.getRandomNumber(getWidth());
            switch (randNum) {
                case (0):
                    addObject(new Enemy(),x,y);
                    break;
                case (1):
                    addObject(new RangedEnemy(),x,y);
                    break;
                default:
                    addObject(new Enemy(),x,y);
                    break;
            }
            lastAdded = curTime;
            enemyCounter--;
            currentEnemies++;
        }
    }
    public void act() {
        spawnMoreEnemies();
    }
    
}
