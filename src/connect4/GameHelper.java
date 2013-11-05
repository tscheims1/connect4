package connect4;

public class GameHelper {

	/**
	 * Check if the specifc player wins the game
	 * @param board
	 * @return
	 */
	public static boolean hasPlayerWon(int[][] board,int player)
	{
		/*
		 * check all horizontal condition
		 * X X X X 
		 */
		for(int y = 0; y < Game.ROWS; y++)
		{
			for(int x =0; x < Game.COLS-4;x++)
			{
				if(board[x][y] == player && board[x+1][y] == player 
				  && board[x+2][y] == player && board[x+3][y] == player)
					return true;
			}
		}
		/*
		 * check vertical condition
		 * X
		 * X
		 * X
		 * X
		 */
		for(int y = 0; y < Game.ROWS -4;y++)
		{
			for(int x = 0; x < Game.COLS; x++)
			{
				if(board[x][y] == player && board[x][y+1] == player &&
					board[x][y+2] == player && board[x][y+3] == player)
					return true;
			}
		}
		/*
		 *
		 * check diagonal condition1
		 *    X
		 *   X 
		 *  X
		 * X
		 */ 
		 for(int y = 0; y < Game.ROWS-4; y++)
		 {
			 for(int x = 0; x < Game.COLS-4;x++)
			 {
				 if(board[x][y] == player && board[x+1][y+1] == player && 
						 board[x+2][y+2] == player && board[x+3][y+3] == player)
				 {
					 return true;
				 }
						 
			 }
		 }
		 /*
		  * check diagonal condition2
		  * X
		  *   X
		  *     X
		  *      X 
		  */
		for(int y = Game.ROWS-1; y-4 < 0;y++ )
		{
			
			for(int x = 0; x < Game.ROWS-4;  x++)
			{
				if(board[x][y] == player && board[x+1][y-1] == player &&
					board[x+2][y-2] == player && board[x+3][y-3] == player)
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
