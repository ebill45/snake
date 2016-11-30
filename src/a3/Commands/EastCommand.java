package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class EastCommand extends AbstractAction{
	GameWorld g;
	
	public EastCommand(GameWorld gw) {
		this.g = gw;
	}

	public void actionPerformed (ActionEvent e) {
		g.moveEast();
		g.notifyObservers();
	}
}
