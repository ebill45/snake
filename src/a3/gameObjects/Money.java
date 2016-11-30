package a3.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import a3.GameWorld;
import a3.IChangeableColor;
import a3.ICollider;

// TODO: Auto-generated Javadoc
/**
 * The Class Money.
 */
public class Money extends FixedObject implements IChangeableColor{
	
	/** The value. */
	private int value; 
	
	/**
	 * Instantiates a new money.
	 */
	public Money(){
		Random rand = new Random();
		setValue(rand.nextInt(100) + 1);
		color = Color.green;		// money starts off green, changes color
	}
	
	/* (non-Javadoc)
	 * @see a3.gameObjects.Objects#setColor(java.awt.Color)
	 */
	@Override
	public void setColor(Color acolor) {
		// TODO Auto-generated method stub
		this.color = acolor;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		String myDesc = "Money: ";
		return myDesc + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " value=" + this.getValue() + " age=" + this.getAge();
	}

	@Override
	public void draw(Graphics g) {
		int width = 10, 
			height = 10,
			xoffset = (int) (this.getX() - width/2),
			yoffset = (int) (this.getY() - height/2);
		
		if(isSelected()){
			g.setColor(Color.MAGENTA);
		}
		else
			g.setColor(this.getColor());
		
		g.drawOval(xoffset, yoffset, width, height);		
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
	public boolean contains(Point p) {
		int px = (int) p.getX();
		int py = (int) p.getY();
		int xLoc = (int) this.getX();
		int yLoc = (int) this.getY();
		if((Math.abs(px-xLoc) < 6) && (Math.abs(py-yLoc) < 6))
			return true;
		else
			return false;
	}
}
