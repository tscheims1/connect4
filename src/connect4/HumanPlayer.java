package connect4;

import java.util.Scanner;

public class HumanPlayer extends Player{

	public HumanPlayer()
	{
		super();
		this.isHumanPlayer = true;
	}
	public int drop(int [][]board)
	{
		Scanner sc = new Scanner(System.in);
		for(;;)
		{
			
			int nextInt = 	sc.nextInt();
			/*
			 * Only return a valid input
			 */
			if(nextInt >= 0 && nextInt <= Game.COLS)
				return nextInt;
		}
	}
}
