package connect4;

public class AIHelper {
	
	/**
	 * Count the number of the winning lines for the last move
	 * @param board
	 * @param lastMove
	 * @param player
	 * @return
	 */
	public int countWinningLines(int board[][],int lastDropX,int player)
	{
		int lastDropY = this.getCurrentRow(board, lastDropX);
		int count = 0;
		/*
		 * Check all posibilitys 4 fields around the drop
		 */
		for(int x = -3; x < 4; x++)
		{
			if(lastDropX +x  < 0 || lastDropX+x >= Game.COLS)
				continue;
			
			if((lastDropY ==0)  || (board[lastDropX +x][lastDropY-1] != player ))
			{
					count+= this.getWinningLines(board, lastDropX+x, lastDropY, player);
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
	/**
	 * Get the amount of winning lines at a specific position
	 * @param board
	 * @param x
	 * @param y
	 * @param player
	 * @return
	 */
	private int getWinningLines(int board[][], int x,int y,int player)
	{
		int countLines  = 0;
		/*
		 * from left to right horizontal
		 */
		if(x + 3 < Game.COLS)
		{
			if((board[x+1][y] == 0 || board[x+1][y] == player)&&
				(board[x+2][y] == 0 || board[x+2][y] == player)&&
				(board[x+3][y] == 0 || board[x+3][y] == player))
				countLines++;
		}
		/*
		 * from right to left horizontal
		 */
		if(x - 3 >= 0)
		{
			if((board[x-1][y] == 0 || board[x-1][y] == player)&&
					(board[x-2][y] == 0 || board[x-2][y] == player)&&
					(board[x-3][y] == 0 || board[x-3][y] == player))
					countLines++;
		}
		/*
		 * from bottom to top vertical
		 */
		if(y +3 < Game.ROWS)
		{
			if((board[x][y+1] == 0 || board[x][y+1] == player)&&
					(board[x][y+2] == 0 || board[x][y+2] == player)&&
					(board[x][y+3] == 0 || board[x][y+3] == player))
					countLines++;
		}
		/*
		 * Diagonal from left to right,bottom to top
		 */
		if(y +3 < Game.ROWS && x + 3 < Game.COLS)
		{
			if((board[x+1][y+1] == 0 || board[x+1][y+1] == player)&&
					(board[x+2][y+2] == 0 || board[x+2][y+2] == player)&&
					(board[x+3][y+3] == 0 || board[x+3][y+3] == player))
					countLines++;
		}
		/*
		 * Diagonal from right to left, top to bottm
		 */
		if(y -3 >=0 && x - 3 >= 0)
		{
			if((board[x-1][y-1] == 0 || board[x-1][y-1] == player)&&
					(board[x-2][y-2] == 0 || board[x-2][y-2] == player)&&
					(board[x-3][y-3] == 0 || board[x-3][y-3] == player))
					countLines++;
		}
		/*
		 * Diagonal from right to left, bottom to top
		 */
		if(y +3 < Game.ROWS && x - 3 >= 0)
		{
			if((board[x-1][y+1] == 0 || board[x-1][y+1] == player)&&
					(board[x-2][y+2] == 0 || board[x-2][y+2] == player)&&
					(board[x-3][y+3] == 0 || board[x-3][y+3] == player))
					countLines++;
		}
		/*
		 * Diagonal from left to to right, top to bottom
		 */
		if(y -3 >= 0 && x +3 < Game.COLS)
		{
			if((board[x+1][y-1] == 0 || board[x+1][y-1] == player)&&
					(board[x+2][y-2] == 0 || board[x+2][y-2] == player)&&
					(board[x+3][y-3] == 0 || board[x+3][y-3] == player))
					countLines++;
		}
		return countLines;
	}

}
