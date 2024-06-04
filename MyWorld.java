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
    public int enemyCounter = 5 + roomCounter;
    public boolean canLeave = false;
    int currentEnemies = 0;
    private GreenfootSound gameMusic;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        gameMusic = new GreenfootSound("normalfight1.mp3");
        enemyCounter = 5 + roomCounter;
        prepare();
        if (roomCounter < 1) {
        showText("Free your friends!", getWidth() / 2, getHeight() / 2-50);
        showText("Thou shalt slay all enemies! Left mouse button to slash and right to pierce!", getWidth() / 2, getHeight() / 2);
        showText("Each FIVE rooms their boss will appear, be careful... and good luck!", getWidth() / 2, getHeight() / 2 + 50);
    
        }
    }
        public void started(){
        gameMusic.playLoop();
    }
        public void stopped(){
        gameMusic.stop();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(player,300,500);
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
            currentEnemies++;
        }
    }
    public void act() {
        spawnMoreEnemies();
    }
    
}
