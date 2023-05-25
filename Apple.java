import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    public void act() 
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        // Removes apple and draw game over when apple touches the bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) {
            world.gameOver();
            world.removeObject(this);
        }
    }    
    
    public void setSpeed(int spd) {
        speed = spd;
    }
}
