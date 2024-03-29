package co.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.gui.IngredientPanel;
import co.gui.MinusButton;
import co.utilities.Util;

public class RemoveIngredientActionListener implements ActionListener {

	private IngredientPanel parentPanel;
	private MinusButton minusButton;
	
	public RemoveIngredientActionListener(IngredientPanel parentPanel, MinusButton minusButton) {
		this.parentPanel = parentPanel;
		this.minusButton = minusButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(parentPanel.getComponentCount() > 2) {
			int panelIndex = Util.getComponentIndex(minusButton.getParent());
			if(panelIndex > -1) {
				minusButton.getParent().setVisible(false);
				parentPanel.remove(panelIndex+1);
				parentPanel.remove(panelIndex);
			}
		}
	}

}
