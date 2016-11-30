package a3.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import a3.GameWorld;
import a3.ICollider;
import a3.IDrawable;

// TODO: Auto-generated Javadoc
/**
 * The Class Bird.
 */
public class Bird extends MovableObject {
	
	/** The size. */
	private int size;
	
	/**
	 * Instantiates a new bird.
	 */
	public Bird(){
		Random rand = new Random();
		setSize(rand.nextInt(5) + 1);		// no size constraints were given, made up range
		color = Color.yellow;		// always yellow for now
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String myDesc = "Bird: ";
		return myDesc + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " speed=" + this.getSpeed() + " heading=" + this.getHeading() + " size=" + this.getSize();
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int width = 20, 
			height = 10,
			xoffset = (int) (this.getX() - width/2),
			yoffset = (int) (this.getY() - height/2);
						
			if(isSelected()){
				g.setColor(Color.MAGENTA);
			}
			else
				g.setColor(this.getColor());
			
			g.fillOval(xoffset, yoffset, width, height);
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
	
		if((Math.abs(px-xLoc) < 12) && (Math.abs(py-yLoc) < 6))
			return true;
		else
			return false;
	}
}
