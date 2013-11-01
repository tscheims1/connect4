package connect4;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GameComponents extends JComponent{

	/**
	 * All Game Components for Painting
	 */
	private ArrayList<GameElement>components;
	
	public void paintComponent(Graphics g)
	{
		/*
		 * Draw all GameElements
		 */
		for(int i = 0; i < this.components.size(); i++)
		{
			this.components.get(i).draw(g);
		}
	}
}
