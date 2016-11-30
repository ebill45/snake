package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class BirdHitCommand  extends AbstractAction{
	
	GameWorld g;
	public BirdHitCommand(GameWorld gw) {
		super("Bird Hit");
		this.g = gw;
	}
	
	public void actionPerformed (ActionEvent e) {
		g.birdCollide();
		g.notifyObservers();
	}
}
