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
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    //Direction the elephant is facing 
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer dashTimer = new SimpleTimer();
    int walkSpeed = 2;
    int dashSpeed = 20;
    /**
     * Contructor
     */
    public Elephant() {
        dashTimer.mark();
        for(int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
               
        animationTimer.mark();
        
        // Initial elephant image
        setImage(idleRight[0]);
    
    }
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant() {
        if(animationTimer.millisElapsed() < 200) {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")) {
            move(-walkSpeed);
            facing = "left";
            //Elephant dashes in the intended direction
            if(dashTimer.millisElapsed() > 1000 && Greenfoot.isKeyDown("space")) {
                move(-dashSpeed);
                dashTimer.mark();
            }
        }
        else if(Greenfoot.isKeyDown("right")) {
            move(walkSpeed);
            facing = "right";
            //Elephant dashes in the intended direction
            if(dashTimer.millisElapsed() > 1000 && Greenfoot.isKeyDown("space")) {
                move(dashSpeed);
                dashTimer.mark();
            }
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
    
    /**
     * Sets walk speed of elephant
     */
    public void setWalkSpeed(int speed) {
        walkSpeed = speed;
    }
}
