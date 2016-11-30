package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class NewCommand extends AbstractAction{
	public NewCommand(){
		super("New");
	}
	public void actionPerformed (ActionEvent e) {
		System.out.println("New command was pressed\n");
	}
}
