package connect4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class HumanPlayer extends Player implements KeyListener {

	private boolean canPress = false;
	private int pressedKey = -1;
	
	public HumanPlayer()
	{
		super();
		this.isHumanPlayer = true;
	}
	public int drop(int [][]board)
	{
		this.canPress = true;
		Scanner sc = new Scanner(System.in);
		for(;;)
		{
			
			//int nextInt = 	sc.nextInt();
			int nextInt = this.pressedKey;
			
			System.out.println("asdf"+nextInt);
			/*
			 * Only return a valid input
			 */
			if(nextInt >= 0 && nextInt <= Game.COLS)
			{
				this.canPress = false;
				return nextInt;
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("asdf");
		if(this.canPress)
			this.pressedKey = (int)e.getKeyChar();
			
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
