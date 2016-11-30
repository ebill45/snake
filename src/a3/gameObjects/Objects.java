package a3.gameObjects;
import java.awt.*;
import java.util.Random;

import a3.IChangeableColor;
import a3.ICollider;
import a3.IDrawable;
import a3.ISelectable;

// TODO: Auto-generated Javadoc
/**
 * The Class Objects.
 */
public abstract class Objects implements IDrawable, ICollider, ISelectable{

	/** The x and y co-ordinates of object */
	private float x, y;
	private boolean isSelected;

	
	/** The color of the object. */
	protected Color color; 
	
	/**
	 * Instantiates a new objects.
	 */
	public Objects() {
		Random rand = new Random();
		this.setX(rand.nextFloat() * (690) + 10);
		this.setY(rand.nextFloat() * (690) + 10);
	}
	
	/**
	 * Sets the x of the object
	 *
	 * @param newX the new x
	 */
	public void setX (float newX) {		// shouldn't be in objects
		this.x = newX;
	}
	
	/**
	 * Sets the y of the object
	 *
	 * @param newY the new y
	 */
	public void setY (float newY){		// shouldn't be in objects
		this.y = newY;
	}
	
	/**
	 * Gets the x co-ordinate of the object.
	 *
	 * @return the x
	 */
	public float getX() {				
		return x;
	}
	
	/**
	 * Gets the y co-ordinate of the object.
	 *
	 * @return the y
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets the color of the object.
	 *
	 * @param aColor the new color
	 */
	public void setColor(Color aColor){		
		if(this instanceof IChangeableColor)
			color = aColor;
	}
	
	/**
	 * Gets the color of the object.
	 *
	 * @return the color
	 */
	public Color getColor(){
		return color;
	}
	

	public void setSelected(boolean yesNo) {
		isSelected = yesNo;
	}


	public boolean isSelected() {
		return isSelected;
	}

}
