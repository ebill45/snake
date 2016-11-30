package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class EatFoodCommand extends AbstractAction{
	GameWorld g;
	public EatFoodCommand(GameWorld gw){
		super("Eat Food");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.foodCollide();
		g.notifyObservers();
	}
}
