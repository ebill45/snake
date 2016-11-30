/*
 * 
 */
package a3;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.util.Scanner;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.System;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import a3.Commands.*;
import a3.gameObjects.Money;
import a3.gameObjects.Walls;

// TODO: Auto-generated Javadoc
// double check what needs to be done in each play choice, may not be just the one method each.

/**
 * The Class Game.
 */
public class Game extends JFrame implements ActionListener {	
	
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private CommandView cv;
	//private char choice =1;
	private Timer myTimer;
	private final int DELAY_IN_MSEC = 20;
	private int time2;
	/**
	 * Instantiates a new game.
	 */
	public Game() {
		
	
		myTimer = new Timer (DELAY_IN_MSEC, this);
		
		gw = new GameWorld();	// create "Observable" GameWorld
		gw.initLayout();		// initialize world
		
		myTimer.start();

		
		mv = new MapView(gw);	// create an "Observer" for the map
		sv = new ScoreView(gw, DELAY_IN_MSEC);	// create an "Observer" for the game state data
		cv = new CommandView(gw, myTimer);
		gw.addObserver(cv);		// register the command Observer
		gw.addObserver(mv); 	// register the map Observer
		gw.addObserver(sv);		// register the score observer
		
		
		BirdHitCommand birdhitCommand = new BirdHitCommand(gw);
		BodyHitCommand bodyhitCommand = new BodyHitCommand(gw);
		MoneyCommand moneyCommand = new MoneyCommand(gw);
		EatFoodCommand eatfoodCommand = new EatFoodCommand(gw);
		NewCommand newCommand = new NewCommand();
		QuitCommand quitCommand = new QuitCommand(gw);
		SaveCommand saveCommand = new SaveCommand();
		AboutCommand aboutCommand = new AboutCommand();
		SoundCommand soundCommand = new SoundCommand(gw);
		UndoCommand undoCommand = new UndoCommand();
		WallHitCommand wallhitCommand = new WallHitCommand(gw);
		WeaselHitCommand weaselhitCommand = new WeaselHitCommand(gw);
		NorthCommand northCommand = new NorthCommand(gw);
		SouthCommand southCommand = new SouthCommand(gw);
		WestCommand westCommand = new WestCommand(gw);
		EastCommand eastCommand = new EastCommand(gw);
		SpaceCommand spaceCommand = new SpaceCommand(gw);
		
		setTitle ("Snake!");
		setSize (1000, 800);
		setLocation (300,250);
		
		// get the focus is in the window input map for the center panel
		int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = mv.getInputMap(mapName);
		KeyStroke leftKey = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
		KeyStroke rightKey = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
		KeyStroke upKey = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
		KeyStroke downKey = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
		KeyStroke spaceKey = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0);
		
		imap.put(leftKey, "left");
		imap.put(rightKey, "right");
		imap.put(upKey, "up");
		imap.put(downKey, "down");
		imap.put(spaceKey, "space");
		
		ActionMap amap = mv.getActionMap();
		
		amap.put("left", westCommand);
		amap.put("right", eastCommand);
		amap.put("up", northCommand);
		amap.put("down", southCommand);
		amap.put("space", spaceCommand);
		
		this.requestFocus();
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenuItem fileMenu = new JMenu("File");
		bar.add(fileMenu);
		
		JMenuItem commandsMenu = new JMenu("Commands");
		bar.add(commandsMenu);
		
		JMenuItem fileNew = new JMenuItem("New");
		fileMenu.add(fileNew);
		JMenuItem fileSave = new JMenuItem("Save");
		fileMenu.add(fileSave);
		JMenuItem fileUndo = new JMenuItem("Undo");
		fileMenu.add(fileUndo);
		JCheckBoxMenuItem fileSound1 = new JCheckBoxMenuItem("Sound", true);
		fileMenu.add(fileSound1);
		JMenuItem fileQuit = new JMenuItem("Quit");
		fileMenu.add(fileQuit);
		JMenuItem fileAbout = new JMenuItem("About");
		fileMenu.add(fileAbout);
		
		fileNew.setAction(newCommand);
		fileSave.setAction(saveCommand);
		fileUndo.setAction(undoCommand);
		fileSound1.setAction(soundCommand);
		fileAbout.setAction(aboutCommand);
		fileQuit.setAction(quitCommand);
		
		JMenuItem commandsBody = new JMenuItem("1 Snake Body Hit");
		JMenuItem commandsBird = new JMenuItem("2 Bird hit Snake");
		JMenuItem commandsMoney = new JMenuItem("3 Snake hit Money");
		JMenuItem commandsFood = new JMenuItem("4 Snake eats Food");
		JMenuItem commandsWall = new JMenuItem("5 Snake hit Wall");
		JMenuItem commandsStrat = new JMenuItem("Change Weasel Strategy");
		JMenuItem commandsWeasel = new JMenuItem("Weasel hit Snake");
		
		commandsMenu.add(commandsBody);
		commandsMenu.add(commandsBird);
		commandsMenu.add(commandsMoney);
		commandsMenu.add(commandsFood);
		commandsMenu.add(commandsWall);
		commandsMenu.add(commandsStrat);
		commandsMenu.add(commandsWeasel);
		
		commandsBody.setAction(bodyhitCommand);
		commandsBird.setAction(birdhitCommand);
		commandsMoney.setAction(moneyCommand);
		commandsFood.setAction(eatfoodCommand);
		commandsWall.setAction(wallhitCommand);
		commandsStrat.setAction(spaceCommand);
		commandsWeasel.setAction(weaselhitCommand);
				
		// bordered panel at top of frame
		sv.setBorder(new LineBorder(Color.blue, 2));
		this.add(sv, BorderLayout.NORTH);	
		
		
		
		cv.setBorder(new TitledBorder("Commands: "));
		cv.setLayout(new GridLayout (10,1));
		this.add(cv, BorderLayout.WEST);
		
		
		//JPanel centerPanel = new JPanel();
		mv.setBorder(new EtchedBorder());
		mv.setBackground(Color.WHITE);
		this.add(mv, BorderLayout.CENTER);
		
		setVisible(true);
		
		/*do{//gw = new GameWorld();
			//gw.initLayout();
			play();
			Scanner in = new Scanner (System.in);
			System.out.println("Do you want to play again (y for yes): ");
			choice = in.next().charAt(0);	//input must be 1 char
		}while(choice == 'y');*/
	}
	
	/**
	 * Play.
	 */
	private void play() {		// no longer used in a3
		char input;
		do{
			input = getCommand();
			switch (input){
			case 'n':
				gw.moveNorth();
				break;
			case 's':
				gw.moveSouth();
				break;
			case 'e':
				gw.moveEast();
				break;
			case 'w':
				gw.moveWest();
				break;
			case '1':
				gw.bodyCollide();
				break;
			case '2':
				gw.birdCollide();
				break;
			case '3':
				gw.moneyCollide();
				break;
			case '4':
				gw.foodCollide();
				gw.makeFood();
				break;
			case '5':
				gw.wallCollide();
				break;
			case 't':
				gw.clockTick(DELAY_IN_MSEC);	//?
				break;
			case 'd':
				gw.display();
				break;
			case 'm':
				gw.map();
				break;
			case 'q':
				gw.quit();
				break;
			default:
				System.out.println("How did the switch get here?");
				break;
			}
		} while (gw.getLives() > 0);	
		System.out.println("YOU LOSE!!!");
	}

	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	private char getCommand() {			// no longer used in a3
	// valid inputs are n, s, e, w, 1, 2, 3, 4, 5, t, d, m, q
		char validinput[] = {'n', 's', 'e', 'w', '1', '2', '3', '4', '5', 't', 'd', 'm', 'q'};
		char command;
		boolean comflag = false;
		Scanner in = new Scanner (System.in);
		do {			
			System.out.println("n-North, s-South, e-East, w-West");
			System.out.println("1-body 2-bird 3-money 4-food 5-wall");
			System.out.println("t-tick d-display m-map q-quit");
			System.out.print("\nEnter command: ");
			command = in.next().charAt(0);	//input must be 1 char
			for (int x = 0; x < validinput.length; x++){	
				if(command == validinput[x])
					comflag = true;
			}
			if (comflag == false)
				System.out.println("Invalid input, try again\n\n");
		} while(comflag== false);
		
		return command;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		float time = 0;
		time++;
		time2++;
		IIterator iter;
			
		gw.clockTick(time);
		gw.notifyObservers();
		
		if (time2 % 500 == 0){
			System.out.println("Changing strats");
			gw.changeStrat();
		}
		
		// check if moving caused collisions
		iter = gw.getTheObjectsCollection().getIterator();
		ICollider head= (ICollider) gw.getMySnake().getMySnake().get(0);
		for(int i = 1; i < gw.getMySnake().getMySnake().size(); i++) {
			ICollider body=(ICollider) gw.getMySnake().getMySnake().get(i);
			if(head.collidesWith(body)){
				System.out.println("OH NOES");
				head.handleCollision(body, gw);
				break;
			}
		}
		while (iter.hasNext()) {
			int i = 0;
			ICollider curObj = (ICollider) iter.getNext();	// get a collidable object
			// check if this object collides with any OTHER object
			IIterator iter2 = gw.getTheObjectsCollection().getIterator();
			while (iter2.hasNext()) {
				ICollider otherObj = (ICollider) iter2.getNext(); // get a collidable object
				if (otherObj != curObj) {	// check that it's not the same object
					// check for collision	
					if (curObj.collidesWith(otherObj)) {
						if(otherObj instanceof Money) {
							gw.moneyCollide(i);
							//break;
						}
						curObj.handleCollision(otherObj, gw);
						break;
					}
				}	
				i++;
			}
		}
	}
}
