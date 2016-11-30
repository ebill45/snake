package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

import a3.GameWorld;

public class PauseCommand extends AbstractAction{
	GameWorld g;
	Timer timer;
	
	public PauseCommand(GameWorld gw, Timer myTimer){
		super("Pause");
		this.g = gw;
		this.timer = myTimer;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		g.pause();
			
		if(g.getPause()){
			timer.stop();
			//g.getBackGroundSound().stop();	
		}
		else{
			timer.restart();
			//g.getBackGroundSound().loop();
		}
		g.notifyObservers();
	}

}





