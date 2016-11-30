package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class SoundCommand extends AbstractAction{
	GameWorld g;
	public SoundCommand(GameWorld gw){
		super("Sound");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		if(g.isSound()){
			g.setSound(false);
			g.getBackGroundSound().stop();
		}
		else {
			g.setSound(true);
			if (g.getPause() == false){
				g.getBackGroundSound().loop();
			}
		}
		g.notifyObservers();
	}
}
