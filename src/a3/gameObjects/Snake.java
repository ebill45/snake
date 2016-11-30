package a3.gameObjects;

import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

import a3.GameWorld;
import a3.ICollider;
import a3.IDrawable;

// TODO: Auto-generated Javadoc
/**
 * The Class Snake.
 */
public class Snake extends MovableObject{
	
	/** The stomach of the snake. */
	private int stomach;
	
	/** The head of the snake. */
	private SnakeHead theHead;
	
	/** The my snake. */
	private ArrayList <MovableObject> mySnake = new ArrayList<MovableObject>();
	
	/**
	 * Instantiates a new snake. Creates new body segment locations based on opposite
	 * direction of the head's heading. Couldn't figure out a prettier way to initialize the segments
	 */
	public Snake(){
		speed = 10;
		setTheHead(new SnakeHead());
		getMySnake().add(getTheHead());
		
		if(getTheHead().getHeading() == 0){
			BodySegment seg1 = new BodySegment(getTheHead().getX(), getTheHead().getY()-10, getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg2 = new BodySegment(getTheHead().getX(), getTheHead().getY()-20, getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg3 = new BodySegment(getTheHead().getX(), getTheHead().getY()-30, getTheHead().getHeading(), getTheHead().getSpeed());
			getMySnake().add(seg1);
			getMySnake().add(seg2);
			getMySnake().add(seg3);
		}
		else if(getTheHead().getHeading() == 90){
			BodySegment seg1 = new BodySegment(getTheHead().getX()-10, getTheHead().getY(), getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg2 = new BodySegment(getTheHead().getX()-20, getTheHead().getY(), getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg3 = new BodySegment(getTheHead().getX()-30, getTheHead().getY(), getTheHead().getHeading(), getTheHead().getSpeed());
			getMySnake().add(seg1);
			getMySnake().add(seg2);
			getMySnake().add(seg3);
		}
		else if(getTheHead().getHeading() == 180){
			BodySegment seg1 = new BodySegment(getTheHead().getX(), getTheHead().getY()+10, getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg2 = new BodySegment(getTheHead().getX(), getTheHead().getY()+20, getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg3 = new BodySegment(getTheHead().getX(), getTheHead().getY()+30, getTheHead().getHeading(), getTheHead().getSpeed());
			getMySnake().add(seg1);
			getMySnake().add(seg2);
			getMySnake().add(seg3);
		}
		else {	
			BodySegment seg1 = new BodySegment(getTheHead().getX()+10, getTheHead().getY(), getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg2 = new BodySegment(getTheHead().getX()+20, getTheHead().getY(), getTheHead().getHeading(), getTheHead().getSpeed());
			BodySegment seg3 = new BodySegment(getTheHead().getX()+30, getTheHead().getY(), getTheHead().getHeading(), getTheHead().getSpeed());
			getMySnake().add(seg1);
			getMySnake().add(seg2);
			getMySnake().add(seg3);
		}
		

	}
	
	
	/**
	 * Move method for the snake. Calls move() for snake head and each body segment,
	 *  using preceding segments co-ordinates.
	 */
	public void move(float time){
		float oldx = getMySnake().get(0).getX();
		float oldy = getMySnake().get(0).getY();
		float tempx = 0;
		float tempy = 0;
		boolean moveflag = false;

		for (int i = 0; i < getMySnake().size(); i++) {
			if(getMySnake().get(i) instanceof SnakeHead) {
				MovableObject mObj = (MovableObject) getMySnake().get(i);
				mObj.move(time);		// might need to fix
				if(getStomach() > 0){
					BodySegment newSeg = new BodySegment(oldx , oldy, getMySnake().get(i).getHeading(), getMySnake().get(i).getSpeed());
					getMySnake().add(1, newSeg);
					digest();
				}
			}else if(getMySnake().get(i) instanceof BodySegment) {
				if(getStomach() == 0){
					if(theHead.getHeading() == 0 || theHead.getHeading() == 180) {
						if(((Math.abs(theHead.getY()- getMySnake().get(i).getY())) > ((BodySegment) getMySnake().get(i)).segsize) && i == 1){
							moveflag = true;
						}
					}
					else if(theHead.getHeading() == 90 || theHead.getHeading() == 270) {
						if(((Math.abs(theHead.getX()- getMySnake().get(i).getX())) > ((BodySegment) getMySnake().get(i)).segsize) && i == 1){
							moveflag = true;
						}
					}
				}
				if(moveflag == true){
					BodySegment tObj = (BodySegment) getMySnake().get(i);
					tempx = getMySnake().get(i).getX();
					tempy = getMySnake().get(i).getY();
					tObj.move(oldx, oldy);
					oldx = tempx;
					oldy = tempy;
				}
			}	
		}
	}	
	
	
	/**
	 * Fill stomach. Adds value of x (food) into the stomach.
	 *
	 * @param x the x
	 */
	public void fillStomach(int x){
		stomach += x;
	}

	/**
	 * Gets the my snake.
	 *
	 * @return the my snake
	 */
	public ArrayList <MovableObject> getMySnake() {
		return mySnake;
	}

	/**
	 * Sets the my snake.
	 *
	 * @param mySnake the new my snake
	 */
	public void setMySnake(ArrayList <MovableObject> mySnake) {
		this.mySnake = mySnake;
	}
	
	/**
	 * Opposite direction. 
	 *
	 * @param dir the dir
	 * @return the int
	 */
	public int oppositeDirection(int dir) {		// not sure if useful
		int opp;
		if(dir == 270)
			opp = 90;
		else
			opp = dir + 180;
		return opp;
	}

	/**
	 * Gets the head.
	 *
	 * @return the the head
	 */
	public SnakeHead getTheHead() {
		return theHead;
	}

	/**
	 * Sets the head.
	 *
	 * @param theHead the new the head
	 */
	public void setTheHead(SnakeHead theHead) {
		this.theHead = theHead;
	}
	
	/**
	 * 
	 * @return stomach
	 */
	public int getStomach() {
		return stomach;
	}
	
	
	// this didn't seem necessary after all, but i'll leave it commented out
	/*public void setStomach(int stomach) {			
		this.stomach = stomach;
	}*/
	
	
	/**
	 *  decreases the value of stomach
	 */
	public void digest() {
		stomach --;
	}
	
	/**
	 * return desc: the string for the entire snake
	 */
	public String toString() {
		String desc = theHead.toString() + '\n';
		for (int i = 1; i < getMySnake().size(); i++) {
			desc += getMySnake().get(i).toString() + '\n';
		}
		return desc;
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		//theHead.draw(g);
		for (int i = 0; i < getMySnake().size(); i++){
			((IDrawable) getMySnake().get(i)).draw(g);
		}
		
	}


	@Override
	public boolean collidesWith(ICollider otherObject) {
		boolean result = false;
		// Snake's collidesWith is essentially that of theHead's
		result = theHead.collidesWith(otherObject);
		
		return result;
	}


	@Override
	public void handleCollision(ICollider otherObject, GameWorld gw) {
		theHead.handleCollision(otherObject, gw);
	}


	@Override
	public void setSelected(boolean yesNo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public boolean contains(Point p) {
			return false;
	}

	//@Override
	/*public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}*/
}
