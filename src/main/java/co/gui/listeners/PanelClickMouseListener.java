package co.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import co.gui.NewRecipe;

public class PanelClickMouseListener implements MouseListener {
	protected String panelName;
	
	public PanelClickMouseListener(String panelName)
	{
		this.panelName = panelName;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (panelName == "create_recipe") 
		{
			NewRecipe newRecipe = new NewRecipe();
			newRecipe.setVisible(true);
			System.out.println("Create recipe");
		}
		else if (panelName == "select_recipe")
			System.out.println("Select recipe");
		else if (panelName == "create_menu")
			System.out.println("Create menu");
		else if (panelName == "all_recipes")
			System.out.println("All recipes");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
