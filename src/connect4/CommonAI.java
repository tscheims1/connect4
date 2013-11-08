package connect4;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CommonAI extends Player{
	
	/*
	 * how deed should the AI Search
	 */
	private int deep = 3;
	private AIHelper aiHelper;
	private int player = 1;
	
	public CommonAI()
	{
		aiHelper = new AIHelper();
		this.isHumanPlayer = false;
	}
	public int drop(int board[][])
	{
		int [] rate =  new int[7];
		for(int x = 0; x < Game.COLS; x++)
		{
			int yDrop = GameHelper.makeFakeMove(board, x, this.player);
			int [][] tmpBoard = GameHelper.copyBoard(board);
			
			tmpBoard[x][yDrop] = this.player;
			/*
			 * if its a invalid drop
			 */
			if(yDrop ==-1)
				continue;
			
			/*
			 * Rate all Moves
			 */
			System.out.println("#####current move:######"+x);
			rate[x] = this.aiHelper.countWinningLines(tmpBoard, x,yDrop, this.player);
		}
		int maxValue = Integer.MIN_VALUE;
		
		/*
		 * Find the best move 
		 */
		int bestMove = -1;
		for(int x = 0; x < Game.COLS; x++)
		{
			System.out.println("Move:"+x+" Value:"+rate[x]);
			if(maxValue < rate[x])
			{
				maxValue = rate[x];
				bestMove = x;
			}
		}
		return (bestMove+1);
	}
	private int maxValue()
	{
		return 1;
	}
	private int minValue()
	{
		return 1;
	}
	/**
	 * This Method Rate the current Move
	 * @return
	 */
	private int rateMove()
	{
		return 1;
	}

	

}
