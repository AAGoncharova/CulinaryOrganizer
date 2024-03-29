package co.gui.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import co.gui.IngredientPanel;
import co.gui.MinusButton;

public class ComboBoxKeyListener implements KeyListener{
	
	private IngredientPanel parentPanel;
	private MinusButton minusButton;
	private boolean isAlreadyAdded;
	
	public ComboBoxKeyListener(IngredientPanel parentPanel, MinusButton minusButton) {
		this.parentPanel = parentPanel;
		this.minusButton = minusButton;
		isAlreadyAdded = false;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(!isAlreadyAdded) {
			parentPanel.addIngredientPanel();
			minusButton.setVisible(true);
			isAlreadyAdded = true;
		}
	}
	
	public void setIsAlreadyAdded(boolean isAdded) {
		isAlreadyAdded = isAdded;
	}

}
