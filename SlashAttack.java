import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlashAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlashAttack extends Actor
{
    GifImage mySlash;
    GreenfootImage myImage1;
    long initialTime = System.currentTimeMillis();
    public SlashAttack()
    {
        mySlash = new GifImage("Slash1.gif");
    }
    public SlashAttack(int rotation)
    {
        turn(rotation);
    }
    /**
     * Act - do whatever the SlashAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        long currentHit = System.currentTimeMillis();
        Vector2D slashToMouse = new Vector2D(mouse.getX() - getX(), mouse.getY() - getY());
        alignWithVector(slashToMouse);
        if(currentHit > initialTime + 200)
        {
            if (getWorld() != null)
            {
                getWorld().removeObject(this);
            }
        }
        else 
        {
            if(currentHit > initialTime + 150){
                checkEnemyCollision();
            }
        }
        
        myImage1 = mySlash.getCurrentImage();
        setImage(myImage1);
    }

        public void checkEnemyCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) 
        {
           processEnemyHit((Enemy) enemy);
        }
    }
    public void processEnemyHit(Enemy enemy)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (enemy.health != 0) {
            enemy.health -= 1;
        } else {
            getWorld().removeObject(enemy);
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
