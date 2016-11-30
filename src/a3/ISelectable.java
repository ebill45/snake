package a3;

import java.awt.Graphics;
import java.awt.Point;

public interface ISelectable {

	public void setSelected(boolean yesNo);
	public boolean isSelected();
	public boolean contains(Point p);
	public void draw(Graphics g);
}
