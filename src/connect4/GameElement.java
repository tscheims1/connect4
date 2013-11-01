package connect4;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

abstract public class GameElement{
	Point position;
	Point size;
	
	abstract public void draw(Graphics g); 
	
	public GameElement(Point position,Point size)
	{
		this.size = size;
		this.position = position;
	}
}
