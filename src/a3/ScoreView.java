package a3;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreView extends JPanel implements IObserver{
	GameWorld g;
	JLabel timeLabel;
	JLabel scoreLabel;
	JLabel livesLabel;
	JLabel soundLabel;
	int timeconv;
	
	public ScoreView(GameWorld gw, int dELAY_IN_MSEC) {
		this.g = gw;
		timeconv = 1000/dELAY_IN_MSEC; 
		timeLabel = new JLabel ("Time: " + (g.getClock()/timeconv));
		scoreLabel = new JLabel ("Current Score: " + g.getScore());
		livesLabel = new JLabel ("Lives Left: " + g.getLives());
		soundLabel = new JLabel ("Sound: ON");
		
		this.add(timeLabel);
		this.add(scoreLabel);
		this.add(livesLabel);
		this.add(soundLabel);
	}
	
	public void update (IObservable o, Object arg) {
		
		timeLabel.setText("Time: " + g.getClock()/timeconv);
		scoreLabel.setText("Current Score: " + g.getScore());
		livesLabel.setText("Lives Left: " + g.getLives());
		if(g.isSound())
			soundLabel.setText("Sound: ON");
		else
			soundLabel.setText("Sound: OFF");
	}
}
