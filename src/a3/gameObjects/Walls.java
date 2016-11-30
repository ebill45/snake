package a3.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import a3.GameWorld;
import a3.ICollider;

// TODO: Auto-generated Javadoc
/**
 * The Class Walls.
 */
public class Walls extends FixedObject{
	
	/** width of wall object */
	private int width;
	
	/** height of wall object */
	private int height;
	
	/**
	 * Instantiates a new walls.
	 *
	 * @param xcord: coordinate of wall
	 * @param ycord:  y coordinate of wall
	 * @param wwidth: wall width
	 * @param wheight: wall height
	 */
	public Walls(float xcord, float ycord, int wwidth, int wheight){
		setX(xcord);
		setY(ycord);
		setHeight(wheight);
		setWidth(wwidth);
		color = Color.DARK_GRAY;
	}
	
	/**
	 * Sets the height of the wall
	 *
	 * @param wheight: wall height
	 */
	public void setHeight(int wheight){
		this.height = wheight;
	}
	
	/**
	 * Sets the width of the wall
	 *
	 * @param wwidth: wall width
	 */
	public void setWidth(int wwidth) {
		this.width = wwidth;
	}
	
	/**
	 * Gets the height of the wall
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Gets the width of the wall
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String myDesc = "Wall: ";
		return myDesc + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " width=" + this.getWidth() + " height=" + this.getHeight() + " age=" + this.getAge();
	}

	@Override
	public void draw(Graphics g) {
		int width = this.getWidth(), 
			height = this.getHeight(),
			xoffset = (int) (this.getX() - width/2),
			yoffset = (int) (this.getY() - height/2);
			g.setColor(this.getColor());
			g.fillRect(xoffset, yoffset, width, height);
		
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
