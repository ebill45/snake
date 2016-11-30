package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class MoneyCommand extends AbstractAction{
	GameWorld g;
	public MoneyCommand(GameWorld gw){
		super("Get Money");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.moneyCollide();
		g.notifyObservers();
	}
}
