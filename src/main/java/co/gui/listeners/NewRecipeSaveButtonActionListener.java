package co.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.logic.dao.Recipe;

public class NewRecipeSaveButtonActionListener implements ActionListener {

	private JPanel parentPanel;
	
	public NewRecipeSaveButtonActionListener(JPanel parentPanel) {
		this.parentPanel = parentPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Recipe newRecipe = new Recipe();
		newRecipe.setName(((JTextField) parentPanel.getComponent(1)).getText());
		newRecipe.setPreparation(((JTextArea) parentPanel.getComponent(3)).getText());
	}

}
