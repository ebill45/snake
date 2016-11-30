package a3;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import a3.gameObjects.Bird;
import a3.gameObjects.BodySegment;
import a3.gameObjects.FixedObject;
import a3.gameObjects.Food;
import a3.gameObjects.Money;
import a3.gameObjects.MovableObject;
import a3.gameObjects.Objects;
import a3.gameObjects.ObjectsCollection;
import a3.gameObjects.Snake;
import a3.gameObjects.SnakeHead;
import a3.gameObjects.Walls;
import a3.gameObjects.Weasel;

// TODO: Auto-generated Javadoc
/**
 * The Class GameWorld.
 */
public class GameWorld implements IObservable, IGameWorld{
	
	private int clock, lives, score;
	private boolean sound;
	private Snake mySnake;		// not sure if necessary
	Random randnum = new Random();
	private ArrayList<IObserver> myObserverList = new ArrayList<IObserver>();
	private ObjectsCollection theObjectsCollection;
	private boolean isPaused;
	
	/** everything stores all the objects (but the snake) in the gameworld */
	
	public Snake createSnake() { return new Snake();}
	public Food createFood() { return new Food();}
	public Bird createBird() { return new Bird();}
	public Weasel createWeasel() { Weasel w = new Weasel(); w.setStrategy(new StrategyBounce(w)); return w;}
	public Money createMoney() { return new Money();}
	public Walls createWalls(float x, float y, int x2, int y2) { return new Walls(x, y, x2, y2);}
	
	private Sound backGroundSound;
	String soundPath = "." + File.separator + "Sounds" + File.separator + "background.wav";
	/*private Sound myCollisionSound;
	String soundDir = "." + File.separator + "Sounds" + File.separator;
	String weaselFile  = "weasel.wav";
	String birdFile = "bird.wav";
	String foodFile = "food.wav";
	String moneyFile = "money.wav";
	String explodeFile = "explode.wav";
	String musicFile = "background.wav";
	String collisionSoundPath;*/
	/**
	 * Instantiates a new game world.
	 */
	public GameWorld() {
		isPaused = false;
		sound = true;
		clock = 0;
		setLives(10);
		score = 0;
		setBackGroundSound(new Sound(soundPath));
		getBackGroundSound().loop();
	}
	
	/**
	 * Inits the layout.
	 */
	public void initLayout() {
		if (lives == 0)System.exit(0);
		setMySnake(createSnake());		
		
		theObjectsCollection = new ObjectsCollection();
		
		theObjectsCollection.add(getMySnake());
		theObjectsCollection.add(createFood());
		theObjectsCollection.add(createBird());
		theObjectsCollection.add(createWeasel());
		theObjectsCollection.add(createWeasel());
		theObjectsCollection.add(createMoney());
		theObjectsCollection.add(createWalls(400, 5, 800, 10));		// south wall
		theObjectsCollection.add(createWalls(400 ,695, 800, 10));	// north wall
		theObjectsCollection.add(createWalls(5, 350, 10, 700));		// west wall
		theObjectsCollection.add(createWalls(795, 350, 10, 700));	// east wall
		// walls go xcord, ycord, wwidth, wheight
		// mapview is width 833, height 700
	}
	
	public ObjectsCollection getTheObjectsCollection() {
		return theObjectsCollection;
	}

	/**
	 * Move west.
	 */
	public void moveWest() {
		if(getMySnake().getTheHead().getHeading() != 90)
			getMySnake().getTheHead().setDirection(270);
	}
	
	/**
	 * Move east.
	 */
	public void moveEast() {
		if(getMySnake().getTheHead().getHeading() != 270)
			getMySnake().getTheHead().setDirection(90);
	}
	
	/**
	 * Move north.
	 */
	public void moveNorth() {
		if(getMySnake().getTheHead().getHeading() != 180)
			getMySnake().getTheHead().setDirection(0);
	}
	
	/**
	 * Move south.
	 */
	public void moveSouth() {
		if(getMySnake().getTheHead().getHeading() != 0)
			getMySnake().getTheHead().setDirection(180);
	}
	
	public void addObserver (IObserver obs) {
		myObserverList.add(obs);
	}
	
	public void notifyObservers() {
		GameWorldProxy proxy = new GameWorldProxy(this);
		for(IObserver o: myObserverList) {
			o.update((IObservable)proxy, null);
		}
	}
	
	/**
	 * Body collide.
	 */
	public void bodyCollide() { 	// input 1
	// decrease lives by 1, reinitialize game world
		System.out.println("Body Collision!\n");
		setLives(getLives() -1);
		initLayout();
	}
	
	/**
	 * Bird collide.
	 */
	public void birdCollide() {		// input 2
	// decrease lives by 1, reinitialize game world	
		System.out.println("Bird Collision!\n");
		setLives(getLives() -1);
		initLayout();
	}
	
	public void weaselCollide() {
	// decrease lives by 1, reinitialize game world
		System.out.println("Weasel Collision!\n");
		setLives(getLives() -1);
		initLayout();
	}
	
	/**
	 * Money collide.
	 */
	public void moneyCollide() {	// input 3
	// remove money from the game and add it's value to player score
	// if there are multiple money items randomly remove one.
	// couldn't think of a cleaner way to randomly remove one
		int index = randnum.nextInt(theObjectsCollection.getEverything().size());		// check if this is the right number
		for (int i = index; i < theObjectsCollection.getEverything().size(); i++) {
			if(theObjectsCollection.getEverything().get(i) instanceof Money) {
				Money tempmoney = (Money) theObjectsCollection.getEverything().get(i);
				score += tempmoney.getValue();
				theObjectsCollection.getEverything().remove(i);
				return;
			}
		}
		for (int i = 0; i < index; i++) {
			if(theObjectsCollection.getEverything().get(i) instanceof Money) {
				Money tempmoney = (Money) theObjectsCollection.getEverything().get(i);
				score += tempmoney.getValue();
				theObjectsCollection.getEverything().remove(i);
				return;
			}
		}
		System.out.println("Money not found");
	
	}
	
	public void delete() {
		for (int i = 0; i < theObjectsCollection.getEverything().size(); i++) {
			if(theObjectsCollection.getEverything().get(i).isSelected()) 
				theObjectsCollection.getEverything().remove(i);
		}
	}
	
	
	public void moneyCollide(int i) {
		Money tempmoney = (Money) theObjectsCollection.getEverything().get(i);
		score += tempmoney.getValue();		
		theObjectsCollection.getEverything().remove(i);
	}
	
	/**
	 * Food collide.
	 */
	public void foodCollide() {		// input 4
	// remove food from world and increase "growth pool" for snake's body,
	// remove one food item randomly, creates 1 or more new foods
		
		for (int i = 0; i < theObjectsCollection.getEverything().size(); i++) {
			if(theObjectsCollection.getEverything().get(i) instanceof Food) {
				Food tempfood = (Food) theObjectsCollection.getEverything().get(i);
				getMySnake().fillStomach(tempfood.getAmount());
				theObjectsCollection.getEverything().remove(i);
				makeFood();
				makeMoney();
				return;
			}
		}
	
		System.out.println("Food not found");
	}
	
	public void foodCollide(int i) {
		
	}
	/**
	 * Wall collide.
	 */
	public void wallCollide() {		// input 5
	// decrease lives by one, reinitialize game world
		System.out.println("Wall Collision!\n");
		setLives(getLives() -1);
		initLayout();
	}
	
	/**
	 * Clock tick.
	 * @param time 
	 */
	public void clockTick(float time) {		// input t
	// clock tick, clock is incremented by 1
	// all movable objects are told to update their positions according to heading
	// and speed
	// run through object array and check if fixed object, increment age on them if they are,
	// otherwise it's a movable object, update it's position
		clock++;
		IIterator theArray = theObjectsCollection.getIterator();
		while (theArray.hasNext()) {
			Objects obj = (Objects) theArray.getNext();
			if(obj instanceof MovableObject) {
				MovableObject mObj = (MovableObject) obj;
				mObj.move(time);
			}
			if(obj instanceof FixedObject) {
				FixedObject fObj = (FixedObject) obj;
				fObj.incAge();
			}	
		}
	
	}
	
	/**
	 * Display.
	 */
	public void display() {			// input d
	// describes current game state values (lives, clock, score), labeled	
		System.out.println("\nCurrent lives: " + getLives());
		System.out.println("Current clock: " + clock);
		System.out.println("Current score: " + score);
	}
	
	
	public void pause() {
		if(isPaused){
			isPaused = false;
			if(isSound()){
				backGroundSound.loop();
			}
		}
		else {	
			isPaused = true;
			backGroundSound.stop();
		}
		
	}
	
	public boolean getPause() {
		return isPaused;
	}
	
	/**
	 * Map.
	 */
	public void map() {				// input m
	// output map showing current world	
	// I would have liked to just do a simple loop but I wanted to show the items 
	// grouped in this order. Newly added items would have shown up after the walls
	// unless I added extra code to make them go in before

		IIterator theArray = theObjectsCollection.getIterator();
		while (theArray.hasNext()) {
			Objects obj = (Objects) theArray.getNext();
			if(obj instanceof MovableObject) {
				System.out.println(obj);
			}
			if(obj instanceof Money) {
				System.out.println(obj);
			}	
			if(obj instanceof Food) {
				System.out.println(obj);
			}	
			if(obj instanceof Walls) {
				System.out.println(obj);
			}	
		}
		
		System.out.println('\n');

	}
	
	/**
	 * Quit.
	 */
	public void quit() {			// input q
	// calls System.exit(0), with confirmation question	
		int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?","Quit",JOptionPane.YES_NO_OPTION);
		if( x == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
		
		
	}	
	
	/**
	 * Make food.
	 */
	public void makeFood() {
		//int num = randnum.nextInt(4);		// could make up to 3 new foods
		//for (int x = 0; x < num; x++){
			theObjectsCollection.getEverything().add(createFood());
		//}

	}
	
	public void makeMoney() {
		int num = randnum.nextInt(4);
		for (int x = 0; x < num; x++){
			theObjectsCollection.getEverything().add(createMoney());
		}
	}
	
	public void changeStrat() {
		IIterator things = theObjectsCollection.getIterator();
		Snake snakee = null;
		
		while(things.hasNext()){
			Objects obj = (Objects) things.getNext();
			if(obj instanceof Snake){
				snakee = (Snake) obj;				
			} 
			else if(obj instanceof Weasel){
				Weasel weaselObj = (Weasel)obj;
				if(weaselObj.getStrategy() instanceof StrategyBounce)
					weaselObj.setStrategy(new StrategyChase(weaselObj, snakee));
				else 
					weaselObj.setStrategy(new StrategyBounce(weaselObj));
			}
		}
	}
	
	public int getClock() {
		return clock;
	}
	public int getScore() {
		return score;
	}
	
	public void setSound(boolean s) {
		sound = s;
	}
	
	public boolean isSound() {
		return sound;
	}
	
	/**
	 * @return the lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @param lives the lives to set
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}
	/**
	 * @return the mySnake
	 */
	public Snake getMySnake() {
		return mySnake;
	}
	/**
	 * @param mySnake the mySnake to set
	 */
	public void setMySnake(Snake mySnake) {
		this.mySnake = mySnake;
	}
	/**
	 * @return the backGroundSound
	 */
	public Sound getBackGroundSound() {
		return backGroundSound;
	}
	/**
	 * @param backGroundSound the backGroundSound to set
	 */
	public void setBackGroundSound(Sound backGroundSound) {
		this.backGroundSound = backGroundSound;
	}
}
