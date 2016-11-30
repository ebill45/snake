package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class SpaceCommand extends AbstractAction{
	GameWorld g;
	public SpaceCommand(GameWorld gw) {
		super("Change Strategies");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.changeStrat();
		g.notifyObservers();
	}
}
