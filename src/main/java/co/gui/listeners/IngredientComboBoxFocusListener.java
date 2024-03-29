package co.gui.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import co.gui.Constants;
import co.gui.NewIngredientFrame;

public class IngredientComboBoxFocusListener implements FocusListener {

	private JComboBox<?> comboBox;
	
	public IngredientComboBoxFocusListener(JComboBox<?> comboBox) {
		this.comboBox = comboBox;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if(comboBox.getSelectedItem() == "")
			comboBox.setSelectedItem(Constants.DefaultIngredientComboboxItem);
		else {
			if(!ingredientExist(comboBox.getEditor().getItem().toString()) && !comboBox.getEditor().getItem().toString().equals(Constants.DefaultIngredientComboboxItem)) {
				int selection = JOptionPane.showConfirmDialog(comboBox.getParent(), "Ингредиент " + (String)comboBox.getEditor().getItem() + " отсутствует в базе данных." +
						"Он будет добавлен после сохранения рецепта. " +
						"Хотите перейти к форме создания нового ингредиента " +
						"для указания дополнительных свойств?", "", JOptionPane.YES_NO_OPTION);
				 if (selection == JOptionPane.YES_OPTION) {
					 System.out.println("Open Dialog");
					 NewIngredientFrame ingredientFrame = new NewIngredientFrame((String)comboBox.getEditor().getItem()/*"ingredient name"*/);
					 ingredientFrame.setVisible(true);
				 } else {
					 System.out.println("Do not open dialog");
				 }
			 }
		}
	}

	private boolean ingredientExist(String ingredientName) {
		boolean exist = false;
		for(int i = 0; i < comboBox.getItemCount(); i++) {
			if(comboBox.getItemAt(i).equals(ingredientName)) {
				exist = true;
				break;
			}
		}
		return exist;
	}
}
