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
    private GreenfootSound slashSound = new GreenfootSound("slasheffect.mp3");
    GreenfootImage myImage1;
    long initialTime = System.currentTimeMillis();
    int slashDamage = 1;
    boolean canSlash = false;
    MyWorld world = (MyWorld) getWorld();
    public SlashAttack()
    {
        mySlash = new GifImage("slash.gif");
        slashSound.play();
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
        if(currentHit > initialTime + 250)
        {
            if (getWorld() != null)
            {
                getWorld().removeObject(this);
            }
        }
        else 
        {
            if(!canSlash){
                checkEnemyCollision();
                checkMiniBossCollision();
                checkRangedEnemyCollision();
                canSlash = true;
            }
        }
        if (currentHit > initialTime + 100) {
            myImage1 = mySlash.getCurrentImage();
            setImage(myImage1);
        }
    }

        public void checkEnemyCollision()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (MyWorld.roomCounter % 5 == 0) {
            slashDamage += 2;
        }
        if (enemy != null) 
        {
           processEnemyHit((Enemy)enemy, slashDamage);
        }
    }
    public void processEnemyHit(Enemy enemy, int dmg)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (enemy.health >= 0) {
            enemy.health -= dmg;
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
            miniBoss.health -= slashDamage;
        } else {
            getWorld().removeObject(miniBoss);

        }
    }
    
        public void checkRangedEnemyCollision()
    {
        Actor ranged = getOneIntersectingObject(RangedEnemy.class);
        if (ranged != null) 
        {
           processRangedEnemyHit((RangedEnemy) ranged);
        }
    }
    
    public void processRangedEnemyHit(RangedEnemy ranged)
    {
        // You could remove health here before in a doDamage method on the enemy for example
        if (ranged.health >= 0) {
            ranged.health -= slashDamage;
        } else {
            getWorld().removeObject(ranged);
    
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
