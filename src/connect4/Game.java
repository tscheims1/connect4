package connect4;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	/**
	 * Informations for the Graphic Classes
	 */
	
	
	public final static int UNIT = 20;
	public final static int ROWS = 6;
	public final static int COLS = 7;
	
	private int [][] board;
	
	public Game()
	{
		/*
		 * Init an empty board
		 */
		board = new int[Game.COLS][Game.ROWS];
		
	}
	public void start()
	{
		
		Board board = new Board();
		
		
		GameComponents gameComponents = new GameComponents();
		gameComponents.add(new Board());
		gameComponents.add(new Stone(1,1,1));
		
		
		
		this.setSize(500, 500);
		this.setTitle("Connect-4");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.add(gameComponents);
		this.repaint();
		//this.loop();
	}
	private void loop()
	{
		for(;;)
		{
			
		}
		
	}
}