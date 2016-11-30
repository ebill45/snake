package a3;

import a3.gameObjects.MovableObject;
import a3.gameObjects.Weasel;

public class StrategyBounce implements IStrategy{
	MovableObject w;
	public StrategyBounce(Weasel client){
		this.w = client;
		
	}
	public void apply() {
		int switchnum = 0;
		float x1, y1;
		x1 = w.getX();
		y1 = w.getY();
		//System.out.println("X1 is" + x1);
		//System.out.println("Y1 is" + y1);
		
		
		// probably need to fix this for corner handling
		if (x1 < 5)	{			// west border
			switchnum = 4;
			if (y1 < 5 || y1 > 700)
				switchnum = 5;
		}
		else if (x1 > 795){		// east border
			switchnum = 2;
			if ( y1 < 5 || y1 > 700)
				switchnum = 5;
		}
		else if (y1 < 5){		// south border
			switchnum = 3;
			if (x1 < 5 || x1 > 700)
				switchnum = 5;
		}
		else if (y1 > 700){		// north border
			switchnum = 1;
			if (x1 < 5 || x1 > 700)
				switchnum = 5;
		}
		
		System.out.println("switchnum is" + switchnum);
		switch (switchnum){
		case 1:		// north
			w.setDirection(180);
			break;
		case 2:		// east
			w.setDirection(270);
			break;
		case 3:		// south
			w.setDirection(0);
			break;
		case 4:		// west
			w.setDirection(90);
			break;
		case 5: 	// corner
			if (w.getHeading() < 180){
				w.setDirection(w.getHeading()+180);
			}
			else { 
				w.setDirection(w.getHeading() - 180);
			}
			break;
		default:
			//System.out.println("How did the switch get here?");
			break;
		}
				
	}

}
