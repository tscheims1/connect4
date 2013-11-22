package connect4;

public class AIHelper {
	
	/**
	 * Count the number of the winning lines for the last move
	 * @param board
	 * @param lastMove
	 * @param player
	 * @return
	 */
	public int countWinningLines(int board[][],int lastDropX,int lastDropY,int player)
	{
		//int lastDropY = this.getCurrentRow(board, lastDropX);
		int count = 0;
		
		/*
		 * Ugly fix for not counting some conditions twice
		 */
		boolean reverseCheck = true;
		
		/*
		 * Check all posibilitys 4 fields around the drop
		 */
		for(int x = -3; x < 4; x++)
		{
			if((lastDropX +x)  < 0 || (lastDropX+x) >= Game.COLS)
				continue;
			
			if((x == 0)||((lastDropY ==0)  || (board[lastDropX +x][lastDropY-1] != player )))
			{
					if(x > 0)
						reverseCheck = false;
					System.out.println("welches element:"+(lastDropX+x));
					count+= this.getWinningLines(board, (lastDropX+x), lastDropY, player,lastDropX,lastDropY, reverseCheck);
			}
					
		}
		
		/*
		 *check all winnin lines
		 */
		return count;
	}
	/**
	 * Get the row of the last Drop
	 * @param board
	 * @param lastDrop
	 * @deprecated dont use this method
	 * @return
	 */
	private int getCurrentRow(int board[][],int lastDrop)
	{
		for(int y = Game.ROWS-1; y <= 0; y++)
		{
			if(board[lastDrop][y] != 0)
			{
				return y;
			}
		}
		return 0;
	}


	 /** Get the amount of winning lines at a specific position
	 * TODO: Improve Diagonal Checks
	 * @param board
	 * @param x
	 * @param y
	 * @param player
	 * @param containsX
	 * @param containsY
	 * @param reverseCheck
	 * @return
	 */
	private int getWinningLines(int board[][], int x,int y,int player,int containsX,int containsY,boolean reverseCheck)
	{
		int countLines  = 0;
		/*
		 * from left to right horizontal
		 */
		if(x + 3 < Game.COLS && x <= containsX && x+3 > containsX)
		{
			System.out.println("horizontal l to r");
			if((board[x+1][y] == 0 || board[x+1][y] == player)&&
				(board[x+2][y] == 0 || board[x+2][y] == player)&&
				(board[x+3][y] == 0 || board[x+3][y] == player))
				countLines++;
		}
		/*
		 * from right to left horizontal
		 */
		if(x - 3 >= 0 && x >= containsX && x-3 < containsX && reverseCheck)
		{
			System.out.println("horizontal r to l ");
			if((board[x-1][y] == 0 || board[x-1][y] == player)&&
					(board[x-2][y] == 0 || board[x-2][y] == player)&&
					(board[x-3][y] == 0 || board[x-3][y] == player))
					countLines++;
		}
		/*
		 * from bottom to top vertical
		 */
		if(y +3 < Game.ROWS && containsX ==x )
		{
			System.out.println("bottom to top");
			if((board[x][y+1] == 0 || board[x][y+1] == player)&&
					(board[x][y+2] == 0 || board[x][y+2] == player)&&
					(board[x][y+3] == 0 || board[x][y+3] == player))
					countLines++;
		}
		/*
		 * Diagonal from left to right,bottom to top
		 */
		if(y +3 < Game.ROWS && x + 3 < Game.COLS && containsX ==x )
		{
			System.out.println("Diagonal from left to right,bottom to top");
			if((board[x+1][y+1] == 0 || board[x+1][y+1] == player)&&
					(board[x+2][y+2] == 0 || board[x+2][y+2] == player)&&
					(board[x+3][y+3] == 0 || board[x+3][y+3] == player))
					countLines++;
		}
		/*
		 * Diagonal from right to left, top to bottm
		 */
		if(y -3 >=0 && x - 3 >= 0 && containsX ==x )
		{
			System.out.println("Diagonal from right to left, top to bottm");
			if((board[x-1][y-1] == 0 || board[x-1][y-1] == player)&&
					(board[x-2][y-2] == 0 || board[x-2][y-2] == player)&&
					(board[x-3][y-3] == 0 || board[x-3][y-3] == player))
					countLines++;
		}
		/*
		 * Diagonal from right to left, bottom to top
		 */
		if(y +3 < Game.ROWS && x - 3 >=  0&& containsX ==x )
		{
			System.out.println("Diagonal from right to left, bottom to top");
			if((board[x-1][y+1] == 0 || board[x-1][y+1] == player)&&
					(board[x-2][y+2] == 0 || board[x-2][y+2] == player)&&
					(board[x-3][y+3] == 0 || board[x-3][y+3] == player))
					countLines++;
		}
		/*
		 * Diagonal from left to to right, top to bottom
		 */
		if(y -3 >= 0 && x +3 < Game.COLS && containsX ==x )
		{
			System.out.println("Diagonal from right to left, bottom to top");
			if((board[x+1][y-1] == 0 || board[x+1][y-1] == player)&&
					(board[x+2][y-2] == 0 || board[x+2][y-2] == player)&&
					(board[x+3][y-3] == 0 || board[x+3][y-3] == player))
					countLines++;
		}
		System.out.println("winingLines"+countLines);
		return countLines;
	}
	/**
	 * get the amount of the last move. check it against the win condition
	 * @param board
	 * @param player
	 * @return
	 */
	public int countWiningMove(int [][]board,int player)
	{
		
		if(GameHelper.hasPlayerWon(board, player))
		{
			System.out.println("player has won");
			return 100;
		}
		return 0;
	}
	public int countMoveAbove(int [][]board,int player,int xDrop)
	{
		int [][] tmpBoard = GameHelper.copyBoard(board);
		
		/*
		 * Count this pattern only if this isn't a winning move
		 */
		if(GameHelper.hasPlayerWon(tmpBoard, player))
			return 0;
		/*
		 * Change the player for checking against
		 */
		player = this.changePlayer(player);
		
		int yDrop = GameHelper.makeFakeMove(tmpBoard, xDrop, player);
		
		if(yDrop == -1)
			return 0;
		
		tmpBoard[xDrop][yDrop] = player;
		if(GameHelper.hasPlayerWon(tmpBoard, player))
			return -99;
		return 0;
		
	}
	/**
	 * Count if the current Move blocks a 4 for in a row for the enemy
	 * @param board
	 * @param player
	 * @param xDrop
	 * @param yDrop
	 * @return
	 */
	public  int  countBlockEnemyMove(int [][] board,int player,int xDrop,int yDrop)
	{
		int [][]tmpBoard = GameHelper.copyBoard(board);
		int enemy =  changePlayer(player);
		tmpBoard[xDrop][yDrop] =enemy;
		if(GameHelper.hasPlayerWon(tmpBoard, enemy))
		{
			return 80;
		}
		return 0;
	}
	/**
	 * This helper method change the player
	 * @param player
	 * @return
	 */
	public  int changePlayer(int player)
	{
		if(player == 1)
			return 2;
		else
			return 1;
	}
	public int countStonesInARow(int [][] board,int player,int xDrop,int yDrop)
	{
		int count = 0;
		/*
		 * Count the horizontal stones
		 */
		int tmpCount = 0;
		for(int y = yDrop; y >= 0;y--)
		{
			if(board[xDrop][y] == player || board[xDrop][y] == 0)
				tmpCount++;
			else
				break;
		}
		count = tmpCount;
		tmpCount = 0;
		
		/*
		 * find out where the furtherest stone is (in range of 4 cols)
		 */
		for(int x = 3; x >=0;x--)
		{
			if(x+ xDrop < Game.COLS && board[xDrop+x][yDrop] == player)
			{
				if(this.checkVerticalLine(board, xDrop, yDrop, xDrop+x, player))
				{
					tmpCount = x;
					break;
				}
			}
		}
		for(int x = 3; x >=0;x--)
		{
			if(xDrop-x  >= 0 && board[xDrop-x][yDrop] == player)
			{
				if(this.checkVerticalLine(board, xDrop, yDrop, xDrop-x, player))
				{
					tmpCount += x;
					break;
				}
			}
		}
		count = Math.max(tmpCount+1, count);
		tmpCount = 0;
		/*
		 * Count vertical stones
		 * first:left to right
		 */
//		
//		
//		for(int x = xDrop;x < Game.COLS;x++)
//		{
//			if(board[x][yDrop] == player || board[x][yDrop] == 0)
//				;//tmpCount++;
//			else
//				break;
//		}
//		/*
//		 * second: right to left
//		 */
//		for(int x = xDrop-1; x >= 0;x--)
//		{
//			if(board[x][yDrop] == player || board[x][yDrop] == 0)
//				;//;tmpCount++;
//			else
//				break;
//		}
//		count = Math.max(tmpCount, count);
//		tmpCount = 0;
		/*
		 * Count diagonal stones (new Version)
		 *         X
		 *       X
		 *     X
		 *  X     
		 */
		for(int x = 3; x >=0; x--)
		{
			if(x+ xDrop < Game.COLS && x+ yDrop < Game.ROWS &&  board[xDrop+x][yDrop+x] == player)
			{
				if(this.checkDiagonalLine(board, xDrop, yDrop, xDrop+x, yDrop+x, player))
				{
					tmpCount = x;
					break;
				}
			}
		}
		for(int x = 3; x >=0; x--)
		{
			if( xDrop-x >= 0 && yDrop-x >=0 &&  board[xDrop-x][yDrop-x] == player)
			{
				if(this.checkDiagonalLine(board, xDrop, yDrop, xDrop-x, x, player))
				{
					tmpCount += x;
					break;
				}
			}
		}
		System.out.println("diagonal Count"+tmpCount);
		count = Math.max(tmpCount+1, count);
		tmpCount =0;
		
		/*
		 * count diagonal stones
		 * X 
		 *   X 
		 *     X
		 *       X
		 */
		for(int x = 3; x >=0; x--)
		{
			if(x+ xDrop < Game.COLS && yDrop -x >=0 &&  board[xDrop+x][yDrop-x] == player)
			{
				if(this.checkDiagonalLine(board, xDrop, yDrop, xDrop+x, yDrop-x, player))
				{
					tmpCount = x;
					break;
				}
			}
		}
		for(int x = 3; x >=0; x--)
		{
			if( xDrop-x >= 0 && yDrop+x < Game.ROWS &&  board[xDrop-x][yDrop+x] == player)
			{
				if(this.checkDiagonalLine(board, xDrop, yDrop, xDrop-x, x+yDrop, player))
				{
					tmpCount += x;
					break;
				}
			}
		}
		
		
//		
//		for(int x = xDrop,y = yDrop;x >= 0 && y < Game.ROWS; x--,y++)
//		{
//			if(board[x][y] == player || board[x][y] == 0)
//				;//tmpCount++;
//			else
//				break;
//		}
//		//second: from top to buttom
//		for(int x = xDrop,y = yDrop-1; y>=0 && x>=0;x--,y--)
//		{
//			if(board[x][y] == player || board[x][y] == 0)
//				;//tmpCount++;
//			else
//				break;
//		}
//		count = Math.max(tmpCount, count);
//		tmpCount =0;
//		
//		/*
//		 * Count diagonal stones
//		 *         X
//		 *        X
//		 *       X
//		 *      X
//		 */
//		//first from bottom to top
//		for(int x = xDrop,y = yDrop;x<Game.COLS && y< Game.ROWS; y++,x++)
//		{
//			if(board[x][y] == player || board[x][y] == 0)
//				;//tmpCount++;
//			else
//				break;
//		}
//		//secound from top to bottom
//		for(int x = xDrop,y = yDrop-1;x<Game.COLS && y>= 0; y--,x++)
//		{
//			if(board[x][y] == player || board[x][y] == 0)
//				;//tmpCount++;
//			else
//				break;
//		}
		count = Math.max(count,tmpCount);
		System.out.println("stones arround"+count);
		return count;
	}
	/**
	 * ugly workaround...
	 * TODO: remove the workaround
	 * @param board
	 * @param xDrop
	 * @param yDrop
	 * @param endX
	 * @param player
	 * @return
	 */
	private boolean checkVerticalLine(int [][]board,int xDrop,int yDrop,int endX,int player)
	{
		int enemy = this.changePlayer(player);
		if(endX <  xDrop )
		{
			for(int x = xDrop; x >= endX; x--)
			{
				if(board[x][yDrop] == enemy)
					return false;
					
			}
		}
		else
		{
			for(int x = xDrop; x <= endX; x++)
			{
				if(board[x][yDrop] == enemy)
					return false;
					
			}
		}
		return true;
	}
	/**
	 * 
	 * @param board
	 * @param xDrop
	 * @param yDrop
	 * @param endX
	 * @param endY
	 * @param player
	 * @return
	 */
	private boolean checkDiagonalLine(int [][] board,int xDrop,int yDrop,int endX,int endY,int player)
	{
		
		int enemy = this.changePlayer(player);
		/*
		 * Count from bottom to top,
		 * from left to right
		 */
		if(endX >= xDrop && endY >= xDrop)
		{
			for(int x = xDrop,y = yDrop; x >= endX; x--,y--)
			{
				if(board[x][y] == enemy)
					return false;
					
			}
			
		}
		/*
		 * Count from top to bottom
		 * from left to right
		 */
		else if(endX < xDrop && endY < xDrop)
		{
			for(int x = xDrop,y = yDrop; x <= endX; x++,y++)
			{
				if(board[x][y] == enemy)
					return false;
					
			}
			
		}
		/*
		 * Count from bottom to top
		 * left to right
		 */
		else if(endX <= xDrop && yDrop <= endY)
		{
			for(int x = xDrop,y = yDrop; x <= endX; x--,y++)
			{
				if(board[x][y] == enemy)
					return false;
					
			}
		}
		else if(endX > xDrop && yDrop > endY)
		{
			for(int x = xDrop,y = yDrop; x <= endX; x++,y--)
			{
				if(board[x][y] == enemy)
					return false;
					
			}
		}
		
		
		
		
		return true;
	}


}
