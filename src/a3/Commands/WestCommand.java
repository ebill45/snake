package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class WestCommand extends AbstractAction{
	GameWorld g;
	
	public WestCommand(GameWorld gw) {
		this.g = gw;
	}

	public void actionPerformed (ActionEvent e) {
		g.moveWest();
		g.notifyObservers();
	}
}
