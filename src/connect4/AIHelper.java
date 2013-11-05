package connect4;

public class AIHelper {
	
	/**
	 * Count the number of the winning lines for the last move
	 * @param board
	 * @param lastMove
	 * @param player
	 * @return
	 */
	public int countWinningLines(int board[][],int lastDrop,int player)
	{
		int lastDropY = this.getCurrentRow(board, lastDrop);
		
		
		int countLines = 0;
		/*
		 *check all winnin lines
		 */
		return 1;
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
	private boolean isWinningLine()
	{
		return true;
	}

}
