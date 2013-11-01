package connect4;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GameComponents extends JComponent{

	/**
	 * All Game Components for Painting
	 */
	private ArrayList<GameElement>components;
	
	public GameComponents()
	{
		components = new ArrayList<GameElement>();
	}
	
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
	public void add(GameElement element)
	{
		this.components.add(element);
	}
}
