package a3.gameObjects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;

import a3.GameWorld;
import a3.ICollider;
import a3.ISteerable;
import a3.Sound;

// TODO: Auto-generated Javadoc
/**
 * The Class SnakeHead.
 */
public class SnakeHead extends MovableObject implements ISteerable{
	float oldX, oldY;
	private Sound myCollisionSound;
	String soundDir = "." + File.separator + "Sounds" + File.separator;
	String weaselFile  = "weasel.wav";
	String birdFile = "bird.wav";
	String foodFile = "food.wav";
	String moneyFile = "money.wav";
	String explodeFile = "explode.wav";
	String musicFile = "background.wav";
	String collisionSoundPath;
	/**
	 * Instantiates a new snake head.
	 */
	public SnakeHead(){
		this.color = Color.BLACK;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		String myDesc = "SnakeHead: ";
		return myDesc + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " speed=" + this.getSpeed() + " heading=" + this.getHeading();
	} 

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		int width = 9, 
			height = 9;
		int []headx = {(int) (this.getX() - width/2), (int) this.getX(), (int) (this.getX() + width/2)};
		int []heady = {(int) (this.getY() - height/2), (int) (this.getY() + height/2), (int) (this.getY() - height/2)};
			
		g.fillPolygon(headx, heady, 3);
		g.setColor(this.getColor());

	}

	@Override
	public boolean collidesWith(ICollider otherObject) {
		boolean result = false;
		
		int thisX = (int) this.getX();
		int thisY = (int) this.getY();
		int otherX = (int) ((Objects) otherObject).getX();
		int otherY = (int) ((Objects) otherObject).getY();
		
		
		if ((Objects) otherObject instanceof Walls) {
			if(thisX < 5 || thisX > 795 || thisY < 5 || thisY > 695)
				result = true;
			/*int wallwidth = ((Walls) otherObject).getWidth();
			int wallheight = ((Walls) otherObject).getHeight();
			if (this.getHeading() == 0) {
				if( (otherY - thisY) < (wallheight/2)){
					result = true;
				}
			}
			if (this.getHeading() == 180) {
				if( (thisY - otherY) < (wallheight/2)) {
					result = true;
				}
			}
			else if( this.getHeading() == 90) {
				if((thisX - otherX) < (wallwidth/2)) {
					result = true;
				}
			}
			else if(this.getHeading() == 270) {
				if((otherX - thisX) < (wallwidth/2)) {
					result = true;
				}
			}*/
		}
		else if((Objects) otherObject instanceof BodySegment) {
			/*if((thisX == otherX)&&(thisY == otherY))
				result = true;*/
			if((Math.abs(thisX-otherX)<2)&&(Math.abs(thisY-otherY)<2))
				result = true;
		}
		else {
			
			// find dist between centers
			int dx = thisX - otherX;
			int dy = thisY - otherY;
			int distSqr = (dx*dx + dy*dy);
		
			// find square of sum of radii
			int thisRadius = 4; // actually 4.5 at max, but most of triangle is less than that
			int otherRadius = 5; // round number that applies to most objects
			int radSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
			if (distSqr <= radSqr) { result = true; }
		}
		
		return result;
	}

	@Override
	public void handleCollision(ICollider otherObject, GameWorld gw) {
		// TODO Auto-generated method stub
		if ((Objects) otherObject instanceof Weasel){
			gw.weaselCollide();  // doesn't really matter what kind of collide it is, snake dies.
			//collisionSoundPath = "./Sounds/weasel.wav";
			collisionSoundPath =soundDir+weaselFile;
		}
		else if ((Objects) otherObject instanceof Bird){
			gw.birdCollide();
			collisionSoundPath =soundDir+birdFile;			
		}
		else if ((Objects) otherObject instanceof Food) {
			gw.foodCollide();
			collisionSoundPath =soundDir+foodFile;
		}
		else if ((Objects) otherObject instanceof Money) {
			//gw.moneyCollide();
			collisionSoundPath =soundDir+moneyFile;
		}
		else if ((Objects) otherObject instanceof Walls) {
			gw.wallCollide();
			collisionSoundPath =soundDir+explodeFile;
		}
		else if ((Objects) otherObject instanceof BodySegment) {
			gw.bodyCollide();
			collisionSoundPath =soundDir+explodeFile;
		}
		System.out.println("sound path is: " + collisionSoundPath);
		myCollisionSound = new Sound(collisionSoundPath);
		if(gw.isSound()){
			myCollisionSound.play();
		}
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
