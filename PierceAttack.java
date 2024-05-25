import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PierceAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PierceAttack extends Actor
{
    /**
     * Act - do whatever the PierceAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage piercing;
    GreenfootImage myImage1;
    long initialTime = System.currentTimeMillis();
    int pierceDamage = 4;
    MyWorld world = (MyWorld) getWorld();
    boolean canPierce = false;
    public PierceAttack()
    {
        piercing = new GifImage("Pierce1.gif");
    }
    public PierceAttack(int rotation)
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
        if(currentHit > initialTime + 950)
        {
            if (getWorld() != null)
            {
                getWorld().removeObject(this);
            }
        }
        else 
        {
            if(currentHit > initialTime && !canPierce){
                checkEnemyCollision();
                checkMiniBossCollision();
                checkRangedEnemyCollision();
                canPierce = true;
            }
        }
        if (currentHit > initialTime + 0) {
            myImage1 = piercing.getCurrentImage();
            setImage(myImage1);
        }
        
    }

        public void checkEnemyCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (MyWorld.roomCounter % 5 == 0) {
            pierceDamage += 4;
        }
        if (enemy != null) 
        {
           processEnemyHit((Enemy)enemy);
        }
    }
    public void processEnemyHit(Enemy enemy)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (enemy.health >= 0) {
            enemy.health -= pierceDamage;
        } else {
            getWorld().removeObject(enemy);
        }
    }
    
        public void checkMiniBossCollision()
    {
        Actor miniBoss = getOneIntersectingObject(MiniBoss.class);
        if (miniBoss != null) 
        {
           processMiniBossHit((MiniBoss) miniBoss);
        }
    }
    public void processMiniBossHit(MiniBoss miniBoss)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (miniBoss.health >= 0) {
            miniBoss.health -= pierceDamage;
        } else {
            getWorld().removeObject(miniBoss);
        }
    }
    
        public void checkRangedEnemyCollision()
    {
        Actor ranged = getOneIntersectingObject(RangedEnemy.class);
        if (ranged != null) 
        {
           processMiniBossHit((RangedEnemy) ranged);
        }
    }
    public void processMiniBossHit(RangedEnemy ranged)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (ranged.health >= 0) {
            ranged.health -= pierceDamage;
        } else {
            getWorld().removeObject(ranged);
   
        }
    }
    
    
    private boolean isRotated = false;
    
    public void alignWithVector(Vector2D v) {
        if (!isRotated) {
            double adjacent = v.getX();
            double opposite = v.getY();
    
            double angleRadians = Math.atan2(opposite, adjacent);
            double angleDegrees = Math.toDegrees(angleRadians);
    
            setRotation((int) angleDegrees);
            isRotated = true;
        }
    }
}
