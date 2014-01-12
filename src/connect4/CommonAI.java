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
	private int searchDeep = 4;
	private int [][][] rateMove;
	
	public CommonAI()
	{
		aiHelper = new AIHelper();
		this.isHumanPlayer = false;
	}
	public int drop(int board[][])
	{
		
		rateMove =  new int[Game.COLS][this.searchDeep][Game.COLS];
		
		/*
		 * Trying to implement the negmax algorithm
		 */
//		this.negMax(board);
//		
//		int deepSearchMove =  this.findBestMove();

		int [] rate = new int[Game.COLS];
		for(int x = 0; x < Game.COLS; x++)
		{
			int yDrop = GameHelper.makeFakeMove(board, x, this.player);
			int [][] tmpBoard = GameHelper.copyBoard(board);
			
			
			System.out.println("XDROP:"+x+"YDrop:"+yDrop);
			/*
			 * if its a invalid drop
			 */
			if(yDrop ==-1)
				continue;
			
			
			tmpBoard[x][yDrop] = this.player;
			
			
			/*
			 * Rate all Moves
			 */
			System.out.println("#####current move:######"+x);
			rate[x] = this.aiHelper.countWinningLines(tmpBoard, x,yDrop, this.player);
			rate[x] += this.aiHelper.countWiningMove(tmpBoard, this.player);
			rate[x] += this.aiHelper.countBlockEnemyMove(tmpBoard, this.player, x, yDrop);
			rate[x] += this.aiHelper.countMoveAbove(tmpBoard, this.player,x);
			rate[x] += this.aiHelper.countStonesInARow(tmpBoard, this.player, x, yDrop);
			
			rate[x] += this.aiHelper.countWiningMove(tmpBoard, player);
			GameHelper.printBoard(tmpBoard);
			
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
		System.out.println("get move back");
		return (bestMove+1);
//		return deepSearchMove;
		
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
	public void negMax(int [][]board)
	{
		/*
		 * Creating a node for every move
		 */
		for(int startMove = 0; startMove < Game.COLS;startMove++)
		{
			//init the first move of the node
			int [][] tmpBoard = GameHelper.copyBoard(board);
			
			int startYPos = GameHelper.makeFakeMove(board, startMove, this.player);
		
			/*
			 * if its a invalid drop
			 */
			if(startYPos ==-1)
			{
				rateMove[startMove][0][startMove] = Integer.MIN_VALUE;
				continue;
			}
			for(int x = 0; x < Game.COLS; x++)
			{
				
				int currentPlayer = this.player;
				for(int deep = 1; deep < this.searchDeep;deep++)
				{
					
					
					int yDrop = GameHelper.makeFakeMove(board, x, currentPlayer);
					
					
					
					System.out.println("XDROP:"+x+"YDrop:"+yDrop);
					/*
					 * if its a invalid drop
					 */
					if(yDrop ==-1)
						break;
					
					
					tmpBoard[x][yDrop] = currentPlayer;
					
					
					/*
					 * Rate all Moves
					 */
					System.out.println("#####current move:######"+x);
					rateMove[startMove][deep][x] = this.aiHelper.countWinningLines(tmpBoard, x,yDrop, currentPlayer);
					int winningMove = this.aiHelper.countWiningMove(tmpBoard, currentPlayer);
					
					rateMove[startMove][deep][x] += this.aiHelper.countBlockEnemyMove(tmpBoard, currentPlayer, x, yDrop);
					rateMove[startMove][deep][x] += this.aiHelper.countMoveAbove(tmpBoard, currentPlayer,x);
					rateMove[startMove][deep][x] += this.aiHelper.countStonesInARow(tmpBoard, currentPlayer, x, yDrop);
					rateMove[startMove][deep][x] += winningMove;
					
					/*
					 * break if the game is finished
					 */
					if(winningMove >0)
					{
						break;
					}
					
					//rate[x] += this.aiHelper.countWiningMove(tmpBoard, player);
					GameHelper.printBoard(tmpBoard);
					
					/*
					 * change the player
					 */
					if(currentPlayer == 1)
						currentPlayer = 2;
					else
						currentPlayer = 1;
				}
	  		}
		}
		
	}
	/*
	 * This method should find the best Move
	 * in the rated threads
	 */
	private int findBestMove()
	{
		int [] rate = new int[Game.COLS];
		
		
		/*
		 * Calculate a single node
		 */
		//Do this for every possible move
		for(int startMove = 0; startMove < Game.COLS; startMove++)
		{
			rate[startMove] = rateMove[startMove][0][startMove];
			for(int deep = 1; deep < this.searchDeep; deep++)
			{
				int maxPoints = Integer.MIN_VALUE;
				int bestMove = -1;
				for(int x = 0; x < Game.COLS; x++)
				{
					if(maxPoints < rateMove[startMove][deep][x])
					{
						bestMove = x;
						maxPoints = rateMove[startMove][deep][x];
					}
				}
				/*
				 * opponents turn
				 */
				if(deep%2 == 0)
				{
					rate[startMove] -= rateMove[startMove][deep][bestMove];
				}
				else
				{
					rate[startMove] += rateMove[startMove][deep][bestMove];
				}
			}
		}
		for(int x = 0; x < this.searchDeep;x++)
		{
			for(int y = 0; y < Game.COLS; y++)
			{
				System.out.println("deep:"+x+" move:"+y+" value:"+rateMove[x][y]);
			}
		}
		/*
		 * Find the best move 
		 */
		int maxValue = Integer.MIN_VALUE;
		int bestMove = -1;
		for(int x = 0; x < Game.COLS; x++)
		{
			System.out.println("Moveeeeeeeeeeeeeee:"+x+" Value:"+rate[x]);
			if(maxValue < rate[x])
			{
				maxValue = rate[x];
				bestMove = x;
			}
		}
		System.out.println("get move back");
		return (bestMove+1);
	}
	
}

