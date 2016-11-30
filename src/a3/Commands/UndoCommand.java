package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class UndoCommand extends AbstractAction{
	public UndoCommand(){
		super("Undo");
	}
	public void actionPerformed (ActionEvent e) {
		System.out.println("UndoCommand invoked");
	}
}
