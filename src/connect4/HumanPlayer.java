package connect4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class HumanPlayer extends Player implements KeyListener {

	private boolean canPress = true;
	private int pressedKey = -1;
	
	public HumanPlayer()
	{
		super();
		this.isHumanPlayer = true;
	}
	public int drop(int [][]board)
	{
		this.canPress = true;
		
		for(;;)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int nextInt = this.pressedKey;
		
			//System.out.println(nextInt);
			/*
			 * Only return a valid input
			 */
			if(nextInt >= 0 && nextInt <= Game.COLS)
			{
				this.canPress = false;
				this.pressedKey  = -1;
				return nextInt;
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(Character.getNumericValue((int)e.getKeyChar()));
		
		this.pressedKey = Character.getNumericValue((int)e.getKeyChar());
			
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
