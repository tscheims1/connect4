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
			for(int x =0; x < Game.COLS-3;x++)
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
		for(int y = 0; y < Game.ROWS -3;y++)
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
		 for(int y = 0; y < Game.ROWS-3; y++)
		 {
			 for(int x = 0; x < Game.COLS-3;x++)
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
		for(int y = Game.ROWS-1; y-3 >= 0;y-- )
		{
			
			for(int x = 0; x < Game.COLS-3;  x++)
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
	/**
	 * This method make a fakeMove and get the y positon of the move
	 * if the move isn't valid, the return value is -1 
	 * @param board
	 * @param dropX
	 * @param player
	 * @return
	 */
	public static int makeFakeMove(int board[][],int dropX, int player)
	{
		for(int y = 0; y < Game.ROWS; y++)
		{
			if(board[dropX][y] == 0)
			{
				
				return y;		
			}
		}
		
		return -1;
	}
}
