package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class NorthCommand extends AbstractAction{
	GameWorld g;
	public NorthCommand(GameWorld gw) {
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		//if(g.getTheObjectsCollection().) {
			g.moveNorth();
			g.notifyObservers();
	}
}
