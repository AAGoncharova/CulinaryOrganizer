package co.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;

import co.gui.Constants;

public class ComboBoxMouseListener implements MouseListener {
	private JComboBox<?> comboBox;

	public ComboBoxMouseListener(JComboBox<?> comboBox) {
		this.comboBox = comboBox;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(comboBox.getSelectedItem() == Constants.DefaultIngredientComboboxItem || comboBox.getSelectedItem() == Constants.DefaultComboboxItem)
			comboBox.setSelectedItem("");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		 
	}

}
