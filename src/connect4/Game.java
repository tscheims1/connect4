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
	
	private GameComponents gameComponents;
	private Player players[] = new Player[2];
	
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
		
		
		gameComponents = new GameComponents();
		gameComponents.add(new Board());
		gameComponents.add(new Stone(1,1,1));
		
		players[0] = new HumanPlayer();
		players[1] = new CommonAI();
		
		this.setSize(500, 500);
		this.setTitle("Connect-4");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.add(gameComponents);
		this.repaint();
		this.loop();
	}
	
	/**
	 * The MAIN Gameloop
	 */
	private void loop()
	{
		for(int i = 0;i < Game.ROWS*Game.COLS;i++)
		{
			int nextDrop = players[i%2].drop();
			
			insertDrop(nextDrop,i%2 +1);
			
			this.repaint();
		}
		
	}
	/**
	 * Insert a Drop in the Boardgame
	 * @param col
	 * @param player
	 */
	private void insertDrop(int col,int player)
	{
		for(int i = 0; i < Game.ROWS;i++)
		{
			if(board[i][col] ==0)
			{
				System.out.println(i +"    "+ col);
				board[i][col] = player;
				gameComponents.add(new Stone(col,i+1,player));
				break;
			}
		}
	}
}