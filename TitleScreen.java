import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(titleLabel, getWidth()/2, 100);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act() {
        //Starts game if user presses space
        if(Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,391,104);
        elephant.setLocation(300,200);
        
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,300,350);
        
        Label label2 = new Label("Use <- and -> to move", 30);
        addObject(label2,300,300);
        
    }
}
