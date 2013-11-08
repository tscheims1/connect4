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
	/**
	 * Get the amount of winning lines at a specific position
	 * TODO: Improve Diagonal Checks
	 * @param board
	 * @param x
	 * @param y
	 * @param player
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

}
