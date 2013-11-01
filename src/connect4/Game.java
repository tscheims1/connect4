package connect4;

import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Game extends JFrame{

	public Game()
	{
		
	}
	public void start()
	{
		Stone StoneA = new Stone();
		Stone StoneB = new Stone();
		Board board = new Board();
		
		
		
		
		this.setSize(500, 500);
		this.setTitle("Connect-4");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.add(new GameComponents());
		this.repaint();
		//this.loop();
	}
	
	private void loop()
	{
		for(;;)
		{
			
		}
	}
	public void paintComponent(Graphics g)
	{
		g.drawLine(10, 10, 10, 10);
	}
}