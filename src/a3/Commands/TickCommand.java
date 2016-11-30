package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;
// This is not used in version 3.0, g.clockTick is called elsewhere
public class TickCommand extends AbstractAction{
	GameWorld g;
	public TickCommand(GameWorld gw){
		super("Tick");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.clockTick(20);		
		g.notifyObservers();
	}
}
