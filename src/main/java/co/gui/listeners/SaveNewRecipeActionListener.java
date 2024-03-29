package co.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.gui.NewRecipe;

public class SaveNewRecipeActionListener implements ActionListener {

	private NewRecipe parentFrame;
	private JPanel dishDescriptionPanel;
	private JPanel imagePanel;
	
	public SaveNewRecipeActionListener(NewRecipe parentFrame, JPanel dishDescriptionPanel, JPanel imagePanel) {
		this.parentFrame = parentFrame;
		this.dishDescriptionPanel = dishDescriptionPanel;
		this.imagePanel = imagePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!parentFrame.isComplete())
			System.out.println("Not complete");
		else
			System.out.println("Complete");
	}
}
