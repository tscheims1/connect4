package connect4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Board extends GameElement{
	
	
	public Board()
	{
		super(new Point(0,0),new Point((Game.UNIT+Game.UNIT/10)*Game.COLS,(Game.UNIT+Game.UNIT/10)*Game.ROWS));

	}
	/**
	 * Draw the Gameboard
	 */
	public void draw(Graphics g	)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawRect(this.position.x, this.position.y, this.size.x, this.size.y);
		for(int i = 0; i < Game.ROWS;i++)
		{
			g2.drawLine(position.x, position.y+(Game.UNIT+Game.UNIT/10)*i, size.x,position.y+(Game.UNIT+Game.UNIT/10)*i);
		}
		
		for(int y = 0; y< Game.COLS;y++)
		{
			g2.drawLine(position.x+(Game.UNIT+Game.UNIT/10)*y, position.y, position.x+(Game.UNIT+Game.UNIT/10)*y,size.y);

		}
		
	}
}
