package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import a3.GameWorld;

public class AboutCommand extends AbstractAction{
	public AboutCommand() {
		super("About");
	}
	public void actionPerformed (ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Bill Yee\nObjects Oriented Graphics\nv3.0");
	}
}
