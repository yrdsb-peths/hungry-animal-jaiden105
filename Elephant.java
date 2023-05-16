import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephant-trumpets-growls-6047.mp3");
    GreenfootImage[] idle = new GreenfootImage[8];
    
    /**
     * Contructor
     */
    public Elephant() {
        for(int i = 0; i < idle.length; i++) {
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant() {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")) {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right")) {
            move(2);
        }
        
        //Removes apple if elephant eats it
        eat();
        
        //Animate elephant
        animateElephant();
    }
    /**
     * When apple is eaten, spawn a new apple 
     */
    
    public void eat() {
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
