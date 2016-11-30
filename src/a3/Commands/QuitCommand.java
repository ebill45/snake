package a3.Commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import a3.GameWorld;

public class QuitCommand extends AbstractAction{
	GameWorld g;
	public QuitCommand(GameWorld gw){
		super("Quit");
		this.g = gw;
	}
	public void actionPerformed (ActionEvent e) {
		g.quit();
	}
}




/*public void quit()
{
	int x = JOptionPane.showConfirmDialog(null, "Quit","Are you sure you want to quit?",JOptionPane.YES_NO_OPTION);
	if( x == JOptionPane.YES_OPTION)
	{
		return;// nukes the program if the user is sure.
	}
}*/