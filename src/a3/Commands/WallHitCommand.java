package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class WallHitCommand extends AbstractAction{
	GameWorld g;
	public WallHitCommand(GameWorld gw){
		super("Wall Hit");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.wallCollide();
		g.notifyObservers();
	}
}
