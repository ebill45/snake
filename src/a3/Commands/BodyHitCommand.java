package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class BodyHitCommand extends AbstractAction{
	GameWorld g;
	public BodyHitCommand(GameWorld gw){
		super("Body Hit");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.bodyCollide();
		g.notifyObservers();
	}
}
