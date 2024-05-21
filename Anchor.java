import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Anchor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Anchor extends Actor
{
    /**
     * Act - do whatever the Anchor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        swingSword();
        
        if (mouse != null) {
            Vector2D cannonToMouse = new Vector2D(mouse.getX() - getX(),
            mouse.getY() - getY());
            
            alignWithVector(cannonToMouse);
        }
        
    }
    
    public void alignWithVector(Vector2D v) {
            double adjacent = v.getX();
            double opposite = v.getY();
            
            double angleRadians = Math.atan2(opposite, adjacent);
            double angleDegrees = Math.toDegrees(angleRadians);
            
            setRotation((int) angleDegrees);
    }
    public Actor owner;
    private int swingSpeed = 5;
    private int rotationSpeed = 10;
    private int initalAngle = -90;
    private int swingAngle = 0;
    private int maxSwingAngle = 90; // Adjust as needed
    private int swingRadius = 50;// Weapon offset from the player
    public void swingSword()
    {
        if (Greenfoot.isKeyDown("space")) {
            // Swing the sword when the space key is pressed
            if (swingAngle < maxSwingAngle) {
                // Rotate the sword
                swingAngle += rotationSpeed;
            }
        } else {
            // Reset the sword back to its original position
            if (swingAngle > 0) {
                // Rotate the sword back to its original position
                swingAngle -= rotationSpeed;
            }
        }
        int rotationAngle = swingAngle % 360; // Keep rotation within 0 to 359 degrees
                
                // Update the actor's rotation
        setRotation(rotationAngle);
        // Rotate the actor around a point.
        int x = owner.getX() + (int) (swingRadius * Math.cos(Math.toRadians(initalAngle + swingAngle)));
        int y = owner.getY() + (int) (swingRadius * Math.sin(Math.toRadians(initalAngle + swingAngle)));
        // Set the sword location 
        setLocation(x, y);
    }
}
