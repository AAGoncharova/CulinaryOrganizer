package co.gui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class NewRecipeComboBoxPanel extends JPanel {
	private JComboBox _comboBox;
	
	public NewRecipeComboBoxPanel(JComboBox<?> comboBox) {
		_comboBox = comboBox;
		
		_comboBox.setPrototypeDisplayValue(co.gui.Constants.NewRecipeComboBoxPrototypeString);
		_comboBox.setMaximumSize(_comboBox.getPreferredSize());

		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layout);
		this.add(_comboBox);
		this.add(Box.createRigidArea(new Dimension(this.getWidth()-_comboBox.getWidth(), 0)));
	}
}
