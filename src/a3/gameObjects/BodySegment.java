package a3.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import a3.GameWorld;
import a3.ICollider;
import a3.IDrawable;

// TODO: Auto-generated Javadoc
/**
 * The Class BodySegment.
 */
public class BodySegment extends MovableObject {
	int segsize = 10;
	/**
	 * Instantiates a new body segment.
	 *
	 * @param x1 x coordinate
	 * @param y1 y coordinate
	 * @param x2 heading
	 * @param y2 speed
	 */
	public BodySegment(float x1, float y1, int x2, int y2){
		super(x2, y2);		// sets the heading and speed, in super constructor
		this.setX(x1);
		this.setY(y1);
		this.color = Color.BLACK;
	}
	
	/**
	 * 
	 */
	public void move(){
		//placeholder move
	}
	
	public void move(float x, float y){
		this.setX(x);
		this.setY(y);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		String myDesc = "Body Segment: ";
		return myDesc + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " speed=" + this.getSpeed() + " heading=" + this.getHeading();
	}

	@Override
	public void draw(Graphics g) {
		int width = 9, 
			height = 9,
			xoffset = (int) (this.getX() - width/2),
			yoffset = (int) (this.getY() - height/2);
			g.fillRect(xoffset, yoffset, width, height);
			g.setColor(this.getColor());

		
	}

	@Override
	public boolean collidesWith(ICollider otherObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleCollision(ICollider otherObject, GameWorld gw) {
		// TODO Auto-generated method stub
		
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
}
