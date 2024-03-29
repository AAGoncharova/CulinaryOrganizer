package co.gui;

import java.awt.Dimension;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import co.gui.listeners.SaveNewIngredientButtonActionListener;
import co.logic.DatabaseManager;
import co.logic.dao.IngredientType;

public class NewIngredientFrame extends JFrame {

	private JPanel contentPane;
	
	public NewIngredientFrame(String ingredientName) {
		JTextField ingredientNameString = new JTextField(ingredientName);
		JTextArea ingredientDescription = new JTextArea();
		JTextField calorificValue = new JTextField();
		JComboBox<String> ingredientType = new JComboBox<String>();

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 100);
		setMinimumSize(new Dimension(100,50));
		setPreferredSize(new Dimension(350,200));
		setSize(getPreferredSize());
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		//contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		setVisible(false);

		//components initialization
		JPanel dishDescription = new JPanel();
		//dishDescription.setLayout(new BoxLayout(dishDescription, BoxLayout.Y_AXIS));
		SpringLayout layout = new SpringLayout();
		dishDescription.setLayout(layout);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		JLabel lTitle = new JLabel("Название:"); // title
		JLabel lDescription = new JLabel("Описание:"); // description
		JLabel lCalorificValue = new JLabel("Калорийность:"); // calorific value
		JLabel lType = new JLabel("Тип"); // type

		JButton cancel = new JButton("Отмена", null); // cancel
		JButton save = new JButton("Сохранить", null); //save

		//set components sizes
		ingredientNameString.setMinimumSize(new Dimension(5,ingredientNameString.getPreferredSize().height));
		ingredientNameString.setMaximumSize(new Dimension(Short.MAX_VALUE,ingredientNameString.getPreferredSize().height));
		ingredientNameString.setPreferredSize(new Dimension(Short.MAX_VALUE, ingredientNameString.getPreferredSize().height));

		ingredientDescription.setMinimumSize(new Dimension(1,5));
		ingredientDescription.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		ingredientDescription.setPreferredSize(new Dimension(Short.MAX_VALUE, 30));

		calorificValue.setMinimumSize(new Dimension(5,calorificValue.getPreferredSize().height));
		calorificValue.setMaximumSize(new Dimension(Short.MAX_VALUE,calorificValue.getPreferredSize().height));
		calorificValue.setPreferredSize(new Dimension(Short.MAX_VALUE, calorificValue.getPreferredSize().height));
		
		ingredientType.setPrototypeDisplayValue(co.gui.Constants.DefaultComboBoxItem);
		ingredientType.setMaximumSize(ingredientType.getPreferredSize());

		save.addActionListener(new SaveNewIngredientButtonActionListener(this, ingredientNameString, ingredientDescription, calorificValue, ingredientType));
		initIngredientType(ingredientType);

		//place components on the form
		dishDescription.add(lTitle);
		//dishDescription.add(Box.createRigidArea(new Dimension(500, 5)));
		dishDescription.add(ingredientNameString);
		dishDescription.add(lDescription);
		dishDescription.add(ingredientDescription);
		dishDescription.add(lCalorificValue);
		dishDescription.add(calorificValue);
		dishDescription.add(lType);
		dishDescription.add(ingredientType);

		//place components on the form
		/*layout.putConstraint(SpringLayout.WEST, lTitle, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lTitle, 5, SpringLayout.NORTH, dishDescription);

		layout.putConstraint(SpringLayout.WEST, title, 5, SpringLayout.EAST, lTitle);
		layout.putConstraint(SpringLayout.NORTH, title, 5, SpringLayout.NORTH, dishDescription);

		layout.putConstraint(SpringLayout.WEST, lIngredients, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lIngredients, 5, SpringLayout.SOUTH, lTitle);

		//layout.putConstraint(SpringLayout.WEST, ingredients, 5, SpringLayout.EAST, lIngredients);
		//layout.putConstraint(SpringLayout.NORTH, ingredients, 5, SpringLayout.SOUTH, title);

		layout.putConstraint(SpringLayout.WEST, ingredientsPanel, 5, SpringLayout.EAST, lIngredients);
		layout.putConstraint(SpringLayout.NORTH, ingredientsPanel, 5, SpringLayout.SOUTH, title);

		layout.putConstraint(SpringLayout.WEST, lPreparation, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lPreparation, 5, SpringLayout.SOUTH, ingredientsPanel);

		layout.putConstraint(SpringLayout.WEST, preparation, 5, SpringLayout.EAST, lPreparation);
		layout.putConstraint(SpringLayout.NORTH, preparation, 5, SpringLayout.SOUTH, ingredientsPanel);

		layout.putConstraint(SpringLayout.WEST, lCuisine, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lCuisine, 5, SpringLayout.SOUTH, preparation);

		//layout.putConstraint(SpringLayout.WEST, cuisine, 5, SpringLayout.EAST, lCuisine);
		//layout.putConstraint(SpringLayout.NORTH, cuisine, 5, SpringLayout.SOUTH, preparation);

		layout.putConstraint(SpringLayout.WEST, cuisineComboboxPanel, 5, SpringLayout.EAST, lCuisine);
		layout.putConstraint(SpringLayout.NORTH, cuisineComboboxPanel, 5, SpringLayout.SOUTH, preparation);

		layout.putConstraint(SpringLayout.WEST, lDishType, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lDishType, 5, SpringLayout.SOUTH, cuisine);

		//layout.putConstraint(SpringLayout.WEST, dishType, 5, SpringLayout.EAST, lDishType);
		//layout.putConstraint(SpringLayout.NORTH, dishType, 5, SpringLayout.SOUTH, cuisine);

		layout.putConstraint(SpringLayout.WEST, dishTypeComboboxPanel, 5, SpringLayout.EAST, lDishType);
		layout.putConstraint(SpringLayout.NORTH, dishTypeComboboxPanel, 5, SpringLayout.SOUTH, cuisine);

		layout.putConstraint(SpringLayout.WEST, lIngredientsType, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lIngredientsType, 5, SpringLayout.SOUTH, dishTypeComboboxPanel);

		//layout.putConstraint(SpringLayout.WEST, ingredientsType, 5, SpringLayout.EAST, lIngredientsType);
		//layout.putConstraint(SpringLayout.NORTH, ingredientsType, 5, SpringLayout.SOUTH, dishType);

		layout.putConstraint(SpringLayout.WEST, ingredientsTypeComboboxPanel, 5, SpringLayout.EAST, lIngredientsType);
		layout.putConstraint(SpringLayout.NORTH, ingredientsTypeComboboxPanel, 5, SpringLayout.SOUTH, dishTypeComboboxPanel);

		layout.putConstraint(SpringLayout.WEST, lDiatery, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lDiatery, 5, SpringLayout.SOUTH, ingredientsType);

		//layout.putConstraint(SpringLayout.WEST, diatery, 5, SpringLayout.EAST, lDiatery);
		//layout.putConstraint(SpringLayout.NORTH, diatery, 5, SpringLayout.SOUTH, ingredientsType);

		layout.putConstraint(SpringLayout.WEST, diateryComboboxPanel, 5, SpringLayout.EAST, lDiatery);
		layout.putConstraint(SpringLayout.NORTH, diateryComboboxPanel, 5, SpringLayout.SOUTH, ingredientsTypeComboboxPanel);

		layout.putConstraint(SpringLayout.EAST, dishDescription, 15, SpringLayout.EAST, title);
		layout.putConstraint(SpringLayout.SOUTH, dishDescription, 5, SpringLayout.SOUTH, diateryComboboxPanel);*/

		/*SpringLayout.Constraints pCons = layout.getConstraints(dishDescription);
		        pCons.setConstraint(SpringLayout.SOUTH, Spring.sum(Spring.constant(5), Spring.sum(Spring.constant(diatery.getLocation().y), Spring.constant(diatery.getHeight()))));
		        pCons.setConstraint(SpringLayout.EAST, Spring.sum(Spring.constant(5), Spring.sum(Spring.constant(diatery.getLocation().x), Spring.constant(diatery.getWidth()))));
		        System.out.println(pCons.getWidth().getMaximumValue());
		        System.out.println(diatery.getLocation().y);
		        System.out.println(diatery.getHeight());*/

		SpringUtilities.makeCompactGrid(dishDescription,
				4, 2, //rows, cols
				5, 5,        //initX, initY
				5, 5);       //xPad, yPad
		/*SpringUtilities.makeCompactGrid(dishDescription2,
		                4, 2, //rows, cols
		                5, 5,        //initX, initY
		                5, 5);       //xPad, yPad*/

		//place content panes

		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(save);
		buttonPanel.add(Box.createRigidArea(new Dimension(5,0)));
		buttonPanel.add(cancel);

		contentPane.add(dishDescription);
		//contentPane.add(dishDescription2);
		contentPane.add(buttonPanel);

		//initComponents();

		//recipe = new Recipe();
	}

	private void initIngredientType(JComboBox ingredientsType) { //TODO: remove duplicate code, same method in NewRecipe
		//Collection<IngredientType> ingredientsTypeList = DatabaseManager.getAllIngredientTypes();
		Collection<IngredientType> ingredientsTypeList = DatabaseManager.getAllElementsOfTypeFromDB(IngredientType.class);
		ingredientsType.insertItemAt(Constants.DefaultComboBoxItem,0);
		for(IngredientType ingredientsTypeName : ingredientsTypeList) {
			ingredientsType.addItem(ingredientsTypeName.getName());
		}
		ingredientsType.setSelectedIndex(0);
	}
}
