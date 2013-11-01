package connect4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Stone extends GameElement {

	private int player;
	
	public Stone(int col,int row,int player)
	{
		/*
		 * Calculate the Graphic position
		 */
		super(
				new Point(((Game.UNIT+Game.UNIT/10)*Game.COLS-(Game.UNIT+Game.UNIT/10))*col,
						((Game.UNIT+Game.UNIT/10)*Game.ROWS-(Game.UNIT+Game.UNIT/10))*row),
				new Point(Game.UNIT,Game.UNIT));
		
		this.player = player;
	}
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		if(player == 1)
			g2.setColor(Color.ORANGE);
		else
			g2.setColor(Color.RED);
		
		Ellipse2D.Double circle = new Ellipse2D.Double(position.x, position.y, size.x, size.y);
		g2.fill(circle);
		
		g2.drawOval(position.x, position.y,size.x,size.y);
		
	}
	
}
