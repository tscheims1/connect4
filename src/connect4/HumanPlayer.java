package connect4;

public class HumanPlayer extends Player{

	public HumanPlayer()
	{
		super();
		this.isHumanPlayer = true;
	}
	public int drop()
	{
		return 1;
	}
}
