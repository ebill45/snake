package a3.gameObjects;

import java.util.Random;

import a3.ISteerable;


// TODO: Auto-generated Javadoc
/**
 * The Class MovableObject.
 */
public abstract class MovableObject extends Objects{
	
	/** The heading in degreed. */
	private int heading;
	
	/** The speed: units per second. */
	protected int speed; 
	
	/**
	 * Instantiates a new movable object.
	 *
	 * @param h the heading
	 * @param s the speed
	 */
	public MovableObject(int h, int s){
		this.heading = h;
		this.speed = s;
	}
	
	/**
	 * Instantiates a new movable object. Randomizes heading of the object
	 */
	public MovableObject(){
		Random rand = new Random();
		int dir = rand.nextInt(4);
		switch(dir)
		{
		case 0:
			this.heading = 0;
			break;
		case 1:
			this.heading = 90;
			break;
		case 2:
			this.heading = 180;
			break;
		case 3:
			this.heading = 270;
			break;	
		}
		this.speed = rand.nextInt(2)+1;
	}
	
	/**
	 * Moves movable objects .
	 * 
	 */
	public void move(float time) {
		float deltaX = (float)(Math.cos(Math.toRadians((90.0-heading))) * speed*time);
		float deltaY = (float)(Math.sin(Math.toRadians((90.0-heading))) * speed*time);
		
		this.setX((this.getX() + deltaX));
		this.setY((this.getY() + deltaY));
	}
	
	/**
	 * Gets the heading of the movable object.
	 *
	 * @return the heading
	 */
	public int getHeading() {
		return heading;
	}
	
	/**
	 * Sets the direction of the movable object. Only usable if ISteerable
	 *
	 * @param x the new direction
	 */
	public void setDirection(int x) {
		if(this instanceof ISteerable)
			this.heading = x;
	}
	
	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int s) {
		this.speed = s;
	}
	
}
