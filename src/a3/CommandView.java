package a3;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import a3.Commands.DeleteCommand;
import a3.Commands.PauseCommand;
import a3.Commands.QuitCommand;
import a3.Commands.SpaceCommand;
import a3.Commands.TickCommand;

public class CommandView extends JPanel implements IObserver {
	GameWorld g;
	String pauseLabel;
	Timer timer;
	JButton ChangeStratButton = new JButton ("Change Strategies");
	JButton TickButton = new JButton ("Tick");
	JButton QuitButton = new JButton ("Quit");
	JButton PauseButton = new JButton ("Play");
	JButton DeleteButton = new JButton ("Delete");
	
	public CommandView(GameWorld gw, Timer myTimer){
		
		this.g = gw;
	
		QuitCommand quitCommand = new QuitCommand(g);
		//TickCommand tickCommand = new TickCommand(g);
		//SpaceCommand spaceCommand = new SpaceCommand(g);
		PauseCommand pauseCommand = new PauseCommand(g, myTimer);
		DeleteCommand deleteCommand = new DeleteCommand(g);
		
		//this.add(ChangeStratButton);
		//this.add(TickButton);
		this.add(PauseButton);
		this.add(DeleteButton);
		this.add(QuitButton);
		
		//ChangeStratButton.setAction(spaceCommand);
		//TickButton.setAction(tickCommand);
		PauseButton.setAction(pauseCommand);
		DeleteButton.setAction(deleteCommand);
		QuitButton.setAction(quitCommand);
		
		// Remove Ability for Space to affect the buttons
		//ChangeStratButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
		//TickButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
		PauseButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
		DeleteButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
		QuitButton.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
	}

	@Override
	public void update(IObservable o, Object arg) {
		// TODO Auto-generated method stub
		if(g.getPause()){
			PauseButton.setText("Play");
			DeleteButton.setEnabled(true);
		}
		if(!g.getPause()){
			PauseButton.setText("Pause");
			DeleteButton.setEnabled(false);
		}
		
	}
			
	
}
