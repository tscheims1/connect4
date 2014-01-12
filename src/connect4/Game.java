package connect4;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.*;

public class Game extends JFrame implements ActionListener{
	
	/**
	 * Informations for the Graphic Classes
	 */
	
	
	public final static int UNIT = 40;
	public final static int ROWS = 6;
	public final static int COLS = 7;
	
	private GameComponents gameComponents;
	private Player players[] = new Player[2];
	

	private JButton quit;
	
	private int [][] board;
	
	public Game()
	{
		
		
	}
	public void start()
	{
		
		/*
		 * Init an empty board
		 */
		board = new int[Game.COLS][Game.ROWS];
		
		//Board board = new Board();
		
		
		gameComponents = new GameComponents();
		gameComponents.add(new Board());
		
		
		players[1] = new HumanPlayer();
		
		players[0] = new CommonAI();
		
		this.setSize(500, 500);
		this.setTitle("Connect-4");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setFocusable(true);
		

		

		
		quit = new JButton("exit");
		quit.addActionListener(this);
		
		JPanel buttons = new JPanel();

		buttons.add(quit);
		this.setVisible(true);
		this.getContentPane().add(gameComponents);
		this.getContentPane().add(buttons,BorderLayout.SOUTH);
		this.repaint();
		this.loop();
	}
	
	private Object getValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * The MAIN Gameloop
	 */
	private void loop()
	{
		this.addKeyListener((KeyListener) players[1]);
		
		for(int i = 0;i < Game.ROWS*Game.COLS;)
		{
			/*
			 * TODO: Only Copy Board for the AI
			 */
			int nextDrop = players[i%2].drop(GameHelper.copyBoard(this.board));
			
			/*
			 * Workarround for testing the game logic
			 */
			
			
			/*
			 * Only continue the when the move is valid
			 */
			if(this.insertDrop(nextDrop,i%2 +1))
				
			this.repaint();
			
			
			if(GameHelper.hasPlayerWon(this.board, i%2+1))
			{
				
				if(i%2 == 0)
				{
			         JOptionPane.showMessageDialog(null,"You have lost the game","", JOptionPane.PLAIN_MESSAGE);
			         resetGame();
				}
			    else
			    {
					JOptionPane.showMessageDialog(null,"You have won the game","", JOptionPane.PLAIN_MESSAGE);
					resetGame();

			    }
			}
			i++;
			
			
		}
		JOptionPane.showMessageDialog(null,"The game ended in a tie","", JOptionPane.PLAIN_MESSAGE);
		resetGame();
		
	}
	/**
	 * Insert a Drop in the Boardgame
	 * @param col
	 * @param player
	 */
	private boolean insertDrop(int col,int player)
	{
		for(int i = 0; i < Game.ROWS;i++)
		{
			if(board[col-1][i] ==0)
			{
				//System.out.println(i +"    "+ col);
				this.board[col-1][i] = player;
				this.gameComponents.add(new Stone(col,i+1,player));
				return true;
			}
		}
		return false;
	}
	private void resetGame()
	{
		board = new int[Game.COLS][Game.ROWS];
		gameComponents.reset();
		gameComponents.add(new Board());
		this.repaint();
		this.loop();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == this.quit)
		{
			System.exit(0);
		}

	}


	
}