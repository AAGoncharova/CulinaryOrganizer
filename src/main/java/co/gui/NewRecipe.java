package co.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Collection;

import javax.swing.BorderFactory;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import co.logic.dao.Cuisine;
import co.logic.dao.Dietary;
import co.logic.dao.DishType;
import co.logic.dao.IngredientType;
import co.logic.dao.Recipe;
import co.gui.listeners.LoadRecipeImageButtonActionListener;
import co.gui.listeners.SaveNewRecipeActionListener;
import co.logic.DatabaseManager;

public class NewRecipe extends JFrame {

	private JTextField title;
	private JTextArea ingredients;
	private JTextArea preparation;
	private JComboBox<String> cuisine;
	private JComboBox<String> dishType;
	private JComboBox<String> ingredientsType;
	private JComboBox<String> dietary;
	co.gui.IngredientPanel ingredientsPanel;
	
	private Recipe recipe;
	
	private JPanel contentPane;
	private final String comboBoxPrototypeString = "WWWWWWWWWWW";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					NewRecipe frame = new NewRecipe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewRecipe() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(650,350));
		setPreferredSize(new Dimension(750,600));
		setSize(new Dimension(750,600));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		//contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		setVisible(false);
		
		//components initialization
		JPanel dishDescription = new JPanel();
		//dishDescription.setLayout(new BoxLayout(dishDescription, BoxLayout.Y_AXIS));
		SpringLayout layout = new SpringLayout();
		dishDescription.setLayout(layout);
		JPanel rightPanel = new JPanel();
		RecipeImagePanel imagePanel = new RecipeImagePanel(null);
		imagePanel.setPreferredSize(new Dimension(300, 200));
		imagePanel.setMaximumSize(imagePanel.getPreferredSize());
		imagePanel.setMinimumSize(imagePanel.getPreferredSize());
		//rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JPanel selectImagePanel = new JPanel();
		selectImagePanel.setLayout(new BoxLayout(selectImagePanel, BoxLayout.X_AXIS));
		JPanel selectPanel = new JPanel();
		selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
		
		JLabel lTitle = new JLabel("Название:"); // title
		JLabel lIngredients = new JLabel("Ингредиенты:"); // ingredients
		JLabel lPreparation = new JLabel("Приготовление:"); // preparation
		JLabel lCuisine = new JLabel("Тип кухни"); // cuisine type
		JLabel lDishType = new JLabel("Тип блюда:"); // dish type
		JLabel lIngredientsType = new JLabel("Тип ингредиентов:"); // ingredients type
		JLabel lDietary = new JLabel("Диетичность:"); // dietary
		
		title = new JTextField();
		ingredients = new JTextArea();
		preparation = new JTextArea();
		cuisine = new JComboBox<>();
		dishType = new JComboBox<>();
		ingredientsType = new JComboBox<>();
		dietary = new JComboBox<>();
		ingredientsPanel = new IngredientPanel();
		//CuisineComboBoxPanel cuisineDropboxPanel = new CuisineComboboxPanel();
		NewRecipeComboBoxPanel cuisineComboBoxPanel = new NewRecipeComboBoxPanel(cuisine);
		NewRecipeComboBoxPanel dishTypeComboBoxPanel = new NewRecipeComboBoxPanel(dishType);
		NewRecipeComboBoxPanel ingredientsTypeComboBoxPanel = new NewRecipeComboBoxPanel(ingredientsType);
		NewRecipeComboBoxPanel dietaryComboBoxPanel = new NewRecipeComboBoxPanel(dietary);
		
		JButton selectImage = new JButton("Загрузить картинку", null); // load image
		JButton cancel = new JButton("Отмена", null); // cancel
		JButton save = new JButton("Сохранить", null); // save
		
		selectImage.addActionListener(new LoadRecipeImageButtonActionListener(imagePanel));
		SaveNewRecipeActionListener saveButtonListener = new SaveNewRecipeActionListener(this, dishDescription, rightPanel);
		save.addActionListener(saveButtonListener);
		
		cuisine.setEditable(true);
		dishType.setEditable(true);
		ingredientsType.setEditable(true);
		dietary.setEditable(true);
		
		//set components sizes
		title.setMinimumSize(new Dimension(5,title.getPreferredSize().height));
		title.setMaximumSize(new Dimension(Short.MAX_VALUE,title.getPreferredSize().height));
		title.setPreferredSize(new Dimension(Short.MAX_VALUE, title.getPreferredSize().height));
		
		ingredients.setMinimumSize(new Dimension(1,5));
		ingredients.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		ingredients.setPreferredSize(new Dimension(Short.MAX_VALUE, 30));
		
		preparation.setMinimumSize(new Dimension(1,5));
		preparation.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
		preparation.setPreferredSize(new Dimension(Short.MAX_VALUE, 30));
		
		cuisine.setPrototypeDisplayValue(comboBoxPrototypeString);
		cuisine.setMaximumSize(cuisine.getPreferredSize());
		dishType.setPrototypeDisplayValue(comboBoxPrototypeString);
		dishType.setMaximumSize(dishType.getPreferredSize());
		ingredientsType.setPrototypeDisplayValue(comboBoxPrototypeString);
		ingredientsType.setMaximumSize(ingredientsType.getPreferredSize());
		dietary.setPrototypeDisplayValue(comboBoxPrototypeString);
		dietary.setMaximumSize(dietary.getPreferredSize());
		
		//place components on the form
		//lTitle.setLocation(5, 5);
		//title.setLocation(5, lTitle.TOP + lTitle.getHeight() + 5);
		
		dishDescription.add(lTitle);
		//dishDescription.add(Box.createRigidArea(new Dimension(500, 5)));
		dishDescription.add(title);
		dishDescription.add(lIngredients);
		//dishDescription.add(ingredients);
		dishDescription.add(ingredientsPanel);
		dishDescription.add(lPreparation);
		dishDescription.add(preparation);
		dishDescription.add(lCuisine);
		//dishDescription.add(cuisine);
		dishDescription.add(cuisineComboBoxPanel);
		dishDescription.add(lDishType);
		//dishDescription.add(dishType);
		dishDescription.add(dishTypeComboBoxPanel);
		dishDescription.add(lIngredientsType); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//dishDescription.add(ingredientsType);
		dishDescription.add(ingredientsTypeComboBoxPanel); //!!!!!!!!!!!!!!!!!!!!!!!!!!!
		dishDescription.add(lDietary);
		//dishDescription.add(diatery);
		dishDescription.add(dietaryComboBoxPanel);
		
		//place components on the form
		layout.putConstraint(SpringLayout.WEST, lTitle, 5, SpringLayout.WEST, dishDescription);
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
		
		layout.putConstraint(SpringLayout.WEST, cuisineComboBoxPanel, 5, SpringLayout.EAST, lCuisine);
		layout.putConstraint(SpringLayout.NORTH, cuisineComboBoxPanel, 5, SpringLayout.SOUTH, preparation);
		
		layout.putConstraint(SpringLayout.WEST, lDishType, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lDishType, 5, SpringLayout.SOUTH, cuisine);
		
		//layout.putConstraint(SpringLayout.WEST, dishType, 5, SpringLayout.EAST, lDishType);
		//layout.putConstraint(SpringLayout.NORTH, dishType, 5, SpringLayout.SOUTH, cuisine);
		
		layout.putConstraint(SpringLayout.WEST, dishTypeComboBoxPanel, 5, SpringLayout.EAST, lDishType);
		layout.putConstraint(SpringLayout.NORTH, dishTypeComboBoxPanel, 5, SpringLayout.SOUTH, cuisine);
		
		layout.putConstraint(SpringLayout.WEST, lIngredientsType, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lIngredientsType, 5, SpringLayout.SOUTH, dishTypeComboBoxPanel);
		
		//layout.putConstraint(SpringLayout.WEST, ingredientsType, 5, SpringLayout.EAST, lIngredientsType);
		//layout.putConstraint(SpringLayout.NORTH, ingredientsType, 5, SpringLayout.SOUTH, dishType);
		
		layout.putConstraint(SpringLayout.WEST, ingredientsTypeComboBoxPanel, 5, SpringLayout.EAST, lIngredientsType);
		layout.putConstraint(SpringLayout.NORTH, ingredientsTypeComboBoxPanel, 5, SpringLayout.SOUTH, dishTypeComboBoxPanel);
		
		layout.putConstraint(SpringLayout.WEST, lDietary, 5, SpringLayout.WEST, dishDescription);
		layout.putConstraint(SpringLayout.NORTH, lDietary, 5, SpringLayout.SOUTH, ingredientsType);
		
		//layout.putConstraint(SpringLayout.WEST, diatery, 5, SpringLayout.EAST, lDiatery);
		//layout.putConstraint(SpringLayout.NORTH, diatery, 5, SpringLayout.SOUTH, ingredientsType);
		
		layout.putConstraint(SpringLayout.WEST, dietaryComboBoxPanel, 5, SpringLayout.EAST, lDietary);
		layout.putConstraint(SpringLayout.NORTH, dietaryComboBoxPanel, 5, SpringLayout.SOUTH, ingredientsTypeComboBoxPanel);
		
		layout.putConstraint(SpringLayout.EAST, dishDescription, 15, SpringLayout.EAST, title);
		layout.putConstraint(SpringLayout.SOUTH, dishDescription, 5, SpringLayout.SOUTH, dietaryComboBoxPanel);
		
		/*SpringLayout.Constraints pCons = layout.getConstraints(dishDescription);
        pCons.setConstraint(SpringLayout.SOUTH, Spring.sum(Spring.constant(5), Spring.sum(Spring.constant(diatery.getLocation().y), Spring.constant(diatery.getHeight()))));
        pCons.setConstraint(SpringLayout.EAST, Spring.sum(Spring.constant(5), Spring.sum(Spring.constant(diatery.getLocation().x), Spring.constant(diatery.getWidth()))));
        System.out.println(pCons.getWidth().getMaximumValue());
        System.out.println(diatery.getLocation().y);
        System.out.println(diatery.getHeight());*/
		
		SpringUtilities.makeCompactGrid(dishDescription,
                7, 2, //rows, cols
                5, 5,        //initX, initY
                5, 5);       //xPad, yPad
		/*SpringUtilities.makeCompactGrid(dishDescription2,
                4, 2, //rows, cols
                5, 5,        //initX, initY
                5, 5);       //xPad, yPad*/
		
		//place content panes
		//buttonPanel.add(Box.createRigidArea(new Dimension(rightPanel.getWidth()-cancel.getWidth()-save.getWidth()-5,0)));
		selectImagePanel.add(Box.createHorizontalGlue());
		selectImagePanel.add(selectImage);
		
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(cancel);
		buttonPanel.add(Box.createRigidArea(new Dimension(5,0)));
		buttonPanel.add(save);
		
		selectPanel.add(imagePanel);
		selectPanel.add(Box.createRigidArea(new Dimension(0,5)));
		selectPanel.add(selectImagePanel);
		
		rightPanel.add(selectPanel, BorderLayout.PAGE_START);
		//rightPanel.add(imagePanel);
		//rightPanel.add(selectImagePanel);
		//rightPanel.add(Box.createRigidArea(new Dimension(0, contentPane.getHeight()-imagePanel.getHeight()-selectImagePanel.getHeight()-buttonPanel.getHeight())));
		rightPanel.add(buttonPanel, BorderLayout.PAGE_END);
		//rightPanel.add(buttonPanel);
		//rightPanel.add(cancel);
		//rightPanel.add(save);
		
		contentPane.add(dishDescription);
		//contentPane.add(dishDescription2);
		contentPane.add(rightPanel);
	/*	setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(450,300));
		setPreferredSize(new Dimension(750,600));
		setSize(new Dimension(750,600));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.setLayout(new SpringLayout());
		setContentPane(contentPane);
		setVisible(false);
		
		//components initialization
		JPanel dishDescription = new JPanel();
		dishDescription.setLayout(new BoxLayout(dishDescription, BoxLayout.Y_AXIS));
		JPanel picture = new JPanel();
		picture.setLayout(new BoxLayout(picture, BoxLayout.X_AXIS));
		
		JLabel lTitle = new JLabel("Ð�Ð°Ð·Ð²Ð°Ð½Ð¸Ðµ");
		JLabel lIngredients = new JLabel("Ð˜Ð½Ð³Ñ€ÐµÐ´Ð¸ÐµÐ½Ñ‚Ñ‹");
		JLabel lPreparation = new JLabel("ÐŸÑ€Ð¸Ð³Ð¾Ñ‚Ð¾Ð²Ð»ÐµÐ½Ð¸Ðµ");
		JLabel lCuisine = new JLabel("Ð¢Ð¸Ð¿ ÐºÑƒÑ…Ð½Ð¸");
		JLabel lDishType = new JLabel("Ð¢Ð¸Ð¿ Ð±Ð»ÑŽÐ´Ð°");
		JLabel lIngredientsType = new JLabel("Ð¢Ð¸Ð¿ Ð¸Ð½Ð³Ñ€ÐµÐ´Ð¸ÐµÐ½Ñ‚Ð¾Ð²");
		JLabel lDiatery = new JLabel("Ð”Ð¸ÐµÑ‚Ð¸Ñ‡Ð½Ð¾Ñ�Ñ‚ÑŒ");
		
		JTextField title = new JTextField();
		JTextArea ingredients = new JTextArea();
		JTextArea preparation = new JTextArea();
		JComboBox<String> cuisine = new JComboBox<>();
		JComboBox<String> dishType = new JComboBox<>();
		JComboBox<String> ingredientsType = new JComboBox<>();
		JComboBox<String> diatery = new JComboBox<>();
		
		JButton cancel = new JButton("ÐžÑ‚Ð¼ÐµÐ½Ð°", null);
		JButton save = new JButton("Ð¡Ð¾Ñ…Ñ€Ð°Ð½Ð¸Ñ‚ÑŒ", null);
		
		//place components on the form
		lTitle.setLocation(5, 5);
		title.setLocation(5, lTitle.TOP + lTitle.getHeight() + 5);
		
		dishDescription.add(lTitle);
		//dishDescription.add(Box.createRigidArea(new Dimension(500, 5)));
		dishDescription.add(title);
		dishDescription.add(lIngredients);
		dishDescription.add(ingredients);
		dishDescription.add(lPreparation);
		dishDescription.add(preparation);
		dishDescription.add(lCuisine);
		dishDescription.add(cuisine);
		dishDescription.add(lDishType);
		dishDescription.add(dishType);
		dishDescription.add(lIngredientsType);
		dishDescription.add(ingredientsType);
		dishDescription.add(lDiatery);
		dishDescription.add(diatery);
		
		picture.add(cancel);
		picture.add(save);
		
		contentPane.add(dishDescription);
		contentPane.add(picture); */
		
		initComponents();
		
		recipe = new Recipe();
	}

	private void initComponents() {
		initCuisineType();
		initDishType();
		initIngredientType();
		initDietaryList();
	}
	
	private void initCuisineType() {
		Collection<Cuisine> cuisineList = DatabaseManager.getAllCuisineTypes();
		cuisine.insertItemAt(Constants.DefaultComboboxItem,0);
		for(Cuisine cuisineName : cuisineList) {
			cuisine.addItem(cuisineName.getName());
		}
		cuisine.setSelectedIndex(0);
	}
	
	private void initDishType() {
		Collection<DishType> dishTypeList = DatabaseManager.getAllDishTypes();
		dishType.insertItemAt(Constants.DefaultComboboxItem,0);
		for(DishType dishTypeName : dishTypeList) {
			dishType.addItem(dishTypeName.getName());
		}
		dishType.setSelectedIndex(0);
	}
	
	private void initIngredientType() {
		Collection<IngredientType> ingredientsTypeList = DatabaseManager.getAllIngredientTypes();
		ingredientsType.insertItemAt(Constants.DefaultComboboxItem,0);
		for(IngredientType ingredientsTypeName : ingredientsTypeList) {
			ingredientsType.addItem(ingredientsTypeName.getName());
		}
		ingredientsType.setSelectedIndex(0);
	}
	
	private void initDietaryList() {
		Collection<Dietary> dietaryList = DatabaseManager.getAllDietaryTypes(/*HibernateUtil.getSessionFactory().openSession()*/);
		dietary.insertItemAt(Constants.DefaultComboboxItem,0);
		for(Dietary dietaryName : dietaryList) {
			dietary.addItem(dietaryName.getName());
		}
		dietary.setSelectedIndex(0);
	}
	
	public boolean isComplete() {
		boolean isComplete = true;
		
		System.out.println("Title text: " + title.getText());
		if(title.getText().equals("")) {
			title.setBorder(BorderFactory.createLineBorder(Color.red));
			isComplete = false;
		}
		if(preparation.getText().equals("")) {
			preparation.setBorder(BorderFactory.createLineBorder(Color.red));
			isComplete = false;
		}
		if(cuisine.getSelectedItem() == "" || cuisine.getSelectedItem() == Constants.DefaultComboboxItem) {
			cuisine.setBorder(BorderFactory.createLineBorder(Color.red));
			isComplete = false;
		}
		if(dishType.getSelectedItem() == "" || dishType.getSelectedItem() == Constants.DefaultComboboxItem) {
			dishType.setBorder(BorderFactory.createLineBorder(Color.red));
			isComplete = false;
		}
		if(ingredientsType.getSelectedItem() == "" || ingredientsType.getSelectedItem() == Constants.DefaultComboboxItem) {
			ingredientsType.setBorder(BorderFactory.createLineBorder(Color.red));
			isComplete = false;
		}
		if(dietary.getSelectedItem() == "" || dietary.getSelectedItem() == Constants.DefaultComboboxItem) {
			dietary.setBorder(BorderFactory.createLineBorder(Color.red));
			isComplete = false;
		}
		if(ingredientsPanel.getIngredientList(recipe).size() == 0) {
			ingredientsPanel.setBorder(BorderFactory.createLineBorder(Color.red));
			isComplete = false;
		}
		
		return isComplete;
	}
}
