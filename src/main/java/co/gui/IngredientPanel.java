package co.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import co.logic.dao.Ingredient;
import co.logic.dao.Recipe;
import co.logic.dao.RecipeIngredient;
import co.gui.listeners.ComboBoxKeyListener;
import co.gui.listeners.ComboBoxMouseListener;
import co.gui.listeners.IngredientComboBoxFocusListener;
import co.gui.listeners.MinusButtonVisibilityListener;
import co.gui.listeners.RemoveIngredientActionListener;
import co.logic.DatabaseManager;

public class IngredientPanel extends JPanel{
	private final String comboBoxPrototypeString = "WWWWWWWWWWWWWWWWWWWWWWWWWWW";
	private Collection<Ingredient> ingredientList;
	
	IngredientPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addRecipePanel();
	}
	
	private void initIngredients(JComboBox<String> ingredientName) {
		ingredientList = DatabaseManager.getAllIngredients();
		//ingredientName.insertItemAt(Constants.DefaultComboboxItem,0);
		for(Ingredient ingredient : ingredientList) {
			ingredientName.addItem(ingredient.getName());
		}
		//ingredientName.setSelectedIndex(0);
		ingredientName.setSelectedItem(co.gui.Constants.DefaultIngredientComboboxItem);
	}
	
	public void addRecipePanel() {
		JPanel ingredientPanel = new JPanel();
		JComboBox<String> ingredientName = new JComboBox<String>();
		JTextField ingredientAmount = new JTextField(9);
		JTextField unitOfMeasurement = new JTextField(4);
		MinusButton minusButton = new MinusButton(this);
		
		ingredientName.setPrototypeDisplayValue(comboBoxPrototypeString);
		ingredientName.setMaximumSize(new Dimension(Short.MAX_VALUE, ingredientName.getPreferredSize().height));
		ingredientName.setMinimumSize(new Dimension(5, ingredientName.getPreferredSize().height));
		
		ingredientAmount.setPreferredSize(new Dimension(9, ingredientName.getPreferredSize().height));
		ingredientAmount.setMaximumSize(ingredientAmount.getPreferredSize());
		ingredientAmount.setMinimumSize(ingredientAmount.getPreferredSize());
		
		unitOfMeasurement.setPreferredSize(new Dimension(4, ingredientName.getPreferredSize().height));
		unitOfMeasurement.setMaximumSize(unitOfMeasurement.getPreferredSize());
		unitOfMeasurement.setMinimumSize(unitOfMeasurement.getPreferredSize());
		
		ingredientName.setEditable(true);
		ingredientName.getEditor().getEditorComponent().addMouseListener(new ComboBoxMouseListener(ingredientName));
		ingredientName.getEditor().getEditorComponent().addFocusListener(new IngredientComboBoxFocusListener(ingredientName));
		ingredientName.getEditor().getEditorComponent().addKeyListener(new ComboBoxKeyListener(this, minusButton));
		
		minusButton.addActionListener(new RemoveIngredientActionListener(this, minusButton));
		minusButton.addComponentListener(new MinusButtonVisibilityListener(ingredientPanel,minusButton, minusButton.getPreferredSize().width));
		//minusButton.setVisible(false);
		
		ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.X_AXIS));
		ingredientPanel.add(ingredientName);
		ingredientPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		ingredientPanel.add(ingredientAmount);
		ingredientPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		ingredientPanel.add(unitOfMeasurement);
		ingredientPanel.add(Box.createRigidArea(new Dimension(5, 0)));
		ingredientPanel.add(minusButton);
		
		initIngredients(ingredientName);
		
		this.add(ingredientPanel);
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		
		minusButton.setVisible(false);
		
		revalidate();
	}
	
	public ArrayList<RecipeIngredient> getIngredientList(Recipe recipe) {
		ArrayList<RecipeIngredient> result = new ArrayList<RecipeIngredient>();
		for(int i=0; i<getComponentCount()-1; i++) {
			if(getComponent(i).getClass().getName().equals(JPanel.class)) {
				JPanel panel = (JPanel) getComponent(i);
				String ingredientName = (String)((JComboBox<String>)panel.getComponent(0)).getSelectedItem();
				if(!ingredientName.equals(co.gui.Constants.DefaultIngredientComboboxItem)) {
					RecipeIngredient ingredient = new RecipeIngredient();
					ingredient.setRecipe(recipe);
					ingredient.setIngredient(findIngredientByName(ingredientName));
					ingredient.setIngredientAmount(Integer.parseInt(((JTextField)panel.getComponent(2)).getText()));
					ingredient.setUnitOfMeasurement(((JTextField)panel.getComponent(4)).getText());
				}
			}
		}
		return result;
	}
	
	private Ingredient findIngredientByName(String name) {
		Ingredient result = null;
		for(Ingredient ingredient : ingredientList) {
			if(ingredient.getName().equals("name")){
				result = ingredient;
				break;
			}
		}
		return result;
	}
}
