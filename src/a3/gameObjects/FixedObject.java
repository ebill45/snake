package a3.gameObjects;

import a3.IDrawable;

// TODO: Auto-generated Javadoc
/**
 * The Class FixedObject.
 */
public abstract class FixedObject extends Objects {

	/** The age. */
	private int age;
	
	/**
	 * Instantiates a new fixed object.
	 */
	public FixedObject(){
		age = 0;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge(){
		return age;
	}
	
	/**
	 * Inc age.
	 */
	public void incAge(){
		age++;
	}
	
	
}
