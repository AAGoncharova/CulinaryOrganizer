package co.gui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CuisineComboBoxPanel extends JPanel {
	JComboBox<String> cuisine;
	JComboBox<String> ingredientsType;
	JComboBox<String> diatery;
	
	public CuisineComboBoxPanel() {
		cuisine = new JComboBox<>();
		/*dishType = new JComboBox<>();
		ingredientsType = new JComboBox<>();
		diatery = new JComboBox<>();*/
		
		cuisine.setPrototypeDisplayValue(co.gui.Constants.NewRecipeComboBoxPrototypeString);
		cuisine.setMaximumSize(cuisine.getPreferredSize());
		/*dishType.setPrototypeDisplayValue(comboBoxPrototypeString);
		dishType.setMaximumSize(dishType.getPreferredSize());
		ingredientsType.setPrototypeDisplayValue(comboBoxPrototypeString);
		ingredientsType.setMaximumSize(ingredientsType.getPreferredSize());
		diatery.setPrototypeDisplayValue(comboBoxPrototypeString);
		diatery.setMaximumSize(diatery.getPreferredSize());*/
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layout);
		this.add(cuisine);
		this.add(Box.createRigidArea(new Dimension(this.getWidth()-cuisine.getWidth(), 0)));
	}
}
