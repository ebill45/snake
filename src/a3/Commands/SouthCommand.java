package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class SouthCommand extends AbstractAction{
	GameWorld g;
	public SouthCommand(GameWorld gw) {
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.moveSouth();
		g.notifyObservers();
	}
}
