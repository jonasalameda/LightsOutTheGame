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
    public int health = maxHealth;
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
            world.addObject(new SlashAttack(90),getX() + 10,getY()-10);
        }
    }
   
    public void act()
    {
       
        if (Greenfoot.isKeyDown("space"))
        {
            attackSlash();
        }
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
        
        if (mouse != null) {
            Vector2D slashToMouse = new Vector2D(mouse.getX() - getX(), mouse.getY() - getY());
            
            alignWithVector(slashToMouse);
            
            if (Greenfoot.mouseClicked(null)) {
                slashToMouse.normalize();
                slashToMouse = Vector2D.multiply(slashToMouse, 10);
                
                SlashAttack attack = new SlashAttack();
                
                getWorld().addObject(attack, getX(), getY());
            }
        }
    }
    
    public void alignWithVector(Vector2D v) {
            double adjacent = v.getX();
            double opposite = v.getY();
            
            double angleRadians = Math.atan2(opposite, adjacent);
            double angleDegrees = Math.toDegrees(angleRadians);
            
            setRotation((int) angleDegrees);
    }
}

