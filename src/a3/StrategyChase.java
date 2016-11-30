package a3;

import a3.gameObjects.Snake;
import a3.gameObjects.Weasel;

public class StrategyChase implements IStrategy{
	Weasel w;
	Snake s;
	
	public StrategyChase(Weasel client, Snake snake) {
		this.w = client;
		this.s = snake;
	}

	public void apply() {
	
		double deltax = s.getTheHead().getX() - w.getX();
		double deltay = s.getTheHead().getY() - w.getY();
		//double degrees = Math.toDegrees(Math.atan2(deltay, deltax));
		
		if (Math.abs(deltax) > Math.abs(deltay))
		{
			if (deltax > 0)
				w.setDirection(90);
			else
				w.setDirection(270);
		}
		else
		{
			if(deltay > 0)
				w.setDirection(0);
			else
				w.setDirection(180);
		}
	}
}
