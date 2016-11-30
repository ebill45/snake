package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class DeleteCommand extends AbstractAction{
	GameWorld g;
	
	public DeleteCommand(GameWorld gw) {
		super("Delete");
		this.g = gw;		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		g.delete();
		g.notifyObservers();		
	}

}
