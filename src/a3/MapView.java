package a3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import a3.gameObjects.Objects;

public class MapView extends JPanel implements IObserver, MouseListener, MouseMotionListener{
	GameWorld g;
	Rectangle box;
	Point anchor;
	
	public MapView(GameWorld gw) {
		// TODO Auto-generated constructor stub
		this.g = gw;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
	}


	public void update (IObservable o, Object arg) {
		g.map();			// old stuff
		this.repaint();        
	}
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		IIterator iterator = g.getTheObjectsCollection().getIterator();
		
		while(iterator.hasNext()){
			((IDrawable) iterator.getNext()).draw(gr);	
		}
		if(box!= null){
			Graphics2D g2d = (Graphics2D)gr;
			g2d.draw(box);	
		}
	}
	
	public void mouseClicked (MouseEvent e) {
		Point p = e.getPoint();
		if(g.getPause()){
		for(int i =0; i < g.getTheObjectsCollection().getEverything().size(); i++){
			if(g.getTheObjectsCollection().getEverything().get(i).contains(p)) 
				g.getTheObjectsCollection().getEverything().get(i).setSelected(true);
			else
				g.getTheObjectsCollection().getEverything().get(i).setSelected(false);
		}
		this.repaint();
		}
	
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		if(g.getPause()){
			anchor = e.getPoint();
			box = new Rectangle(anchor);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(g.getPause()){
			int minx = (int) box.getMinX();
			int maxx = (int) box.getMaxX();
			int miny = (int) box.getMinY();
			int maxy = (int) box.getMaxY();
			int obx;
			int oby;
		
			for(int i =0; i < g.getTheObjectsCollection().getEverything().size(); i++){
				Objects theObj = g.getTheObjectsCollection().getEverything().get(i);
				obx = (int) theObj.getX();
				oby = (int) theObj.getY();
				if((obx > minx) && (obx < maxx) && (oby > miny) && (oby < maxy))
					g.getTheObjectsCollection().getEverything().get(i).setSelected(true);
				else
					g.getTheObjectsCollection().getEverything().get(i).setSelected(false);
			}
			box = null;
			this.repaint();
		}
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		if(g.getPause()){
			int bound1 = (int)Math.min(anchor.x,e.getX());
			int bound2 = (int)Math.min(anchor.y,e.getY());
			int bound3 = (int)Math.abs(e.getX()-anchor.x);
			int bound4 = (int)Math.abs(e.getY()-anchor.y);
			box.setBounds( bound1, bound2, bound3, bound4);
			this.repaint();
		}
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
