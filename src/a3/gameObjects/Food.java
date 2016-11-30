package a3.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import a3.GameWorld;
import a3.ICollider;

// TODO: Auto-generated Javadoc
/**
 * The Class Food.
 */
public class Food extends FixedObject{
	
	/** The amount. */
	private int amount;
	
	/**
	 * Instantiates a new food.
	 */
	public Food(){
		Random rand = new Random();
		setAmount(rand.nextInt(10) + 1);
		color = Color.red;		// always red for now
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		String myDesc = "Food: ";
		return myDesc + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " amount=" + this.getAmount() + " age=" + this.getAge();
	}

	@Override
	public void draw(Graphics g) {

		int width = 10, 
			height = 10,
			xoffset = (int) (this.getX() - width/2),
			yoffset = (int) (this.getY() - height/2);
			
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
			return false;
		
	}
}
