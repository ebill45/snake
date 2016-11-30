package a3.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import a3.GameWorld;
import a3.ICollider;
import a3.ISteerable;
import a3.IStrategy;
import a3.StrategyBounce;
import a3.StrategyChase;

public class Weasel extends MovableObject implements ISteerable{

	private IStrategy curStrategy;
	
	public Weasel(){
		//curStrategy = new StrategyBounce();	// should change this
		this.color = Color.BLACK;
		Random rand = new Random();
		this.setSpeed(rand.nextInt(1)+1);
	}
	
	
	public void setStrategy(IStrategy s) {
		curStrategy = s;
	}
	
	public IStrategy getStrategy() {
		return curStrategy;
	}
	
	public void invokeStrategy() {
		curStrategy.apply();
	}
	
	public String toString() {
		
		if(curStrategy instanceof StrategyBounce){
			return "Weasel: (Bounce):" + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " speed=" + this.getSpeed() + " heading=" + this.getHeading();
		}
		else if(curStrategy instanceof StrategyChase){
			return "Weasel: (Chase):" + String.format("%.0f", this.getX()) + "," + String.format("%.0f", this.getY()) + " color=" + this.getColor()+ " speed=" + this.getSpeed() + " heading=" + this.getHeading();
		}
		else
			return "No strategy";
	}
	
	public void move(float time){
			
		this.invokeStrategy();
		super.move(time);
	}


	@Override
	public void draw(Graphics g) {
		int width = 10, 
			height = 20,
			xoffset = (int) (this.getX() - width/2),
			yoffset = (int) (this.getY() - height/2);
		if(isSelected()){
			g.setColor(Color.MAGENTA);
		}
		else
			g.setColor(this.getColor());
			
		g.drawRect(xoffset, yoffset, width, height);		
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
		
		if((Math.abs(px-xLoc) < 8) && (Math.abs(py-yLoc) < 12))
			return true;
		else
			return false;
	}



}
