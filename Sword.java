import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Sword extends Actor {
    public Actor owner;
    private int swingSpeed = 10;
    private int rotationSpeed = 90;
    private int initalAngle = -85;
    private int swingAngle = 0;
    private int maxSwingAngle = 90; // Adjust as needed
    private int swingRadius = 50;// Weapon offset from the player
    boolean space = false;
    public void swingSword()
    {
        if (owner == null)
          return;
          
        if (Greenfoot.isKeyDown("space")) {
            // Swing the sword when the space key is pressed
            space = true;
        } else if (space && !Greenfoot.isKeyDown("space")) {
             space = false;  
             checkEnemyCollision();
            if (swingAngle < maxSwingAngle) {
                // Rotate the sword
                swingAngle += rotationSpeed;
                checkEnemyCollision();
            }
        } else {
            // Reset the sword back to its original position
            if (swingAngle > 0) {
                // Rotate the sword back to its original position
                swingAngle -= 10;
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
    public void checkEnemyCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) 
        {
           processEnemyHit((Enemy) enemy);
        }
    }
    public void processEnemyHit( Enemy enemy)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (enemy.health != 0) {
            enemy.health -= 1;
            Greenfoot.delay(1);
        } else {
            getWorld().removeObject(enemy);
        }
    }
   public void act() 
   {
        swingSword();
   }
}