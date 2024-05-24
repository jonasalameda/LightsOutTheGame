import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public Sword sword;
    private int speed = 4;
    private int maxHealth = 100;
    public int health = 100;
    long lastSlash = System.currentTimeMillis();
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public void attackSlash()
    {
        World world = getWorld();
        long currentSlash = System.currentTimeMillis();
        if(currentSlash > lastSlash + 1000)
        {
            lastSlash = System.currentTimeMillis();
            // Look up the canonball lab for spawning with mouse
            // Use the constructor to change the rotation
            world.addObject(new SlashAttack(90),getX(),getY());
        }
    }
    
    public void act()
    {
        int enemyCounter = getWorld().getObjects(Enemy.class).size();
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed); // Move upwards
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed); // Move downwards
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY()); // Move left
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY()); // Move right
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && getObjectsInRange(150, SlashAttack.class).isEmpty()) {
            Vector2D playerToMouse = new Vector2D(mouse.getX() - getX(), mouse.getY() - getY());
            alignWithVector(playerToMouse);
            
            if (mouse.getButton() == 1) {
                playerToMouse.normalize();
                playerToMouse = Vector2D.multiply(playerToMouse, 20);
                
                SlashAttack attack = new SlashAttack();
                
                getWorld().addObject(attack, getX(), getY());
            }
        }
          if (enemyCounter == 0){
            checkRoomTransition1();
        }
    }
    
    public void alignWithVector(Vector2D v) {
            double adjacent = v.getX();
            double opposite = v.getY();
            
            double angleRadians = Math.atan2(opposite, adjacent);
            double angleDegrees = Math.toDegrees(angleRadians);
            
            setRotation((int) angleDegrees);
    }
    
        public void checkRoomTransition1() {
        int randomNum = Greenfoot.getRandomNumber(3);
        if (getY() <= 10 && MyWorld.roomCounter % 5 != 0 && MyWorld.roomCounter % 10 != 0) {
            MyWorld.roomCounter++;
            switch(randomNum) {
                case(0):
                    Greenfoot.setWorld(new Room1());
                    break;
                case(1):
                    Greenfoot.setWorld(new Room2());
                    break;
                default:
                    Greenfoot.setWorld(new MyWorld());
                    break;
            }
        } else if (getY()>getWorld().getHeight()-10 && MyWorld.roomCounter % 5 != 0 && MyWorld.roomCounter % 10 != 0) {
            MyWorld.roomCounter++;
            switch(randomNum) {
                case(0):
                    Greenfoot.setWorld(new Room1());
                    break;
                case(1):
                    Greenfoot.setWorld(new Room2());
                    break;
                default:
                    Greenfoot.setWorld(new MyWorld());
                    break;
            }
        } else if (MyWorld.roomCounter % 5 == 0 && MyWorld.roomCounter % 10 != 0) {
            Greenfoot.setWorld(new MiniBossRoom());
        }
    }
}

