package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SaveCommand extends AbstractAction{
	public SaveCommand(){
		super("Save");
	}
	public void actionPerformed (ActionEvent e) {
		System.out.println("Save command was pressed");
	}
}
