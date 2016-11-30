package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class WeaselHitCommand extends AbstractAction{
	GameWorld g;
	public WeaselHitCommand(GameWorld gw){
		super("Weasel Hit");
		this.g = gw;
	}
	
	public void actionPerformed (ActionEvent e) {
		g.weaselCollide();
		g.notifyObservers();
	}
}
