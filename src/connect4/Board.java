package connect4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Board extends GameElement{
	
	private int border = 2;
	
	public Board()
	{
		super(new Point(0,0),new Point(400,400));

	}
	
	public void draw(Graphics g	)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawRect(this.position.x, this.position.y, this.size.x, this.size.y);
		
		
	}
}
