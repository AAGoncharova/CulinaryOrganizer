package co.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.apache.commons.io.IOUtils;

import co.gui.listeners.PanelClickMouseListener;
import co.logic.constants.IconPathConstant;

public class StartForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartForm frame = new StartForm();
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
	public StartForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(450,300));
		setPreferredSize(new Dimension(750,600));
		setSize(new Dimension(750,600));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		//load button icons

		BufferedImage image;
		ImageIcon icon1 = new ImageIcon();
		ImageIcon icon2 = new ImageIcon();
		ImageIcon icon3 = new ImageIcon();
		ImageIcon icon4 = new ImageIcon();
		try {
			image = ImageIO.read(new FileInputStream(IconPathConstant.NEW_RECIPE_START_FORM_ICON_PATH));
			icon1.setImage(image);
			image = ImageIO.read(new FileInputStream(IconPathConstant.SELECT_RECIPE_START_FORM_ICON_PATH));
			icon2.setImage(image);
			image = ImageIO.read(new FileInputStream(IconPathConstant.CREATE_MENU_START_FORM_ICON_PATH));
			icon3.setImage(image);
			image = ImageIO.read(new FileInputStream(IconPathConstant.ALL_RECIPES_START_FORM_ICON_PATH));
			icon4.setImage(image);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	    
		//Button-Panels
		//Top row
		JPanel contentPanelTop = new JPanel();
		contentPanelTop.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight()/2);
		contentPanelTop.setMinimumSize(new Dimension(426,125));
		contentPanelTop.setLayout(new BoxLayout(contentPanelTop, BoxLayout.X_AXIS));
		
		JLabel label1 = new JLabel(icon1);
		JPanel createRecipe = new JPanel(new BorderLayout(0,0));
		createRecipe.setBackground(new Color(230,133,100));
		createRecipe.setBounds(0, 0,  contentPane.getWidth()/2,  contentPane.getHeight()/2);
		createRecipe.setMinimumSize(new Dimension(213,125));
		//createRecipe.setBorder(new EmptyBorder(0, 0, 3, 3));
		createRecipe.add(label1, BorderLayout.CENTER);
		createRecipe.setName("create_recipe");
		createRecipe.addMouseListener(new PanelClickMouseListener(createRecipe.getName()));
		//contentPanelTop.add(createRecipe);
		
		JLabel label2 = new JLabel(icon2);
		JPanel selectRecipe = new JPanel(new BorderLayout(0,0));
		selectRecipe.setBackground(new Color(172,156,201));
		selectRecipe.setBounds(createRecipe.getWidth(),0, contentPane.getWidth()/2, contentPane.getHeight()/2);
		selectRecipe.setMinimumSize(new Dimension(213,125));
		//selectRecipe.setBorder(new EmptyBorder(0, 3, 3, 0));
		selectRecipe.add(label2, BorderLayout.CENTER);
		selectRecipe.setName("select_recipe");
		selectRecipe.addMouseListener(new PanelClickMouseListener(selectRecipe.getName()));
		contentPanelTop.add(selectRecipe);
		contentPanelTop.add(createRecipe);
		
		//Buttom row
		JPanel contentPanelButtom = new JPanel();
		contentPanelButtom.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight()/2);
		contentPanelButtom.setMinimumSize(new Dimension(426,125));
		contentPanelButtom.setLayout(new BoxLayout(contentPanelButtom, BoxLayout.X_AXIS));
		
		JLabel label3 = new JLabel(icon3);
		JPanel createMenu = new JPanel(new BorderLayout(0,0));
		createMenu.setBackground(new Color(157,196,151));;
		//createMenu.setBounds(contentPanelButtom.getWidth()/2,0, contentPanelButtom.getWidth()/2, contentPanelButtom.getHeight());
		createMenu.setBounds(0,0, contentPane.getWidth()/2, contentPane.getHeight()/2);
		createMenu.setMinimumSize(new Dimension(213,125));
		//createMenu.setBorder(new EmptyBorder(3, 0, 0, 3));
		createMenu.add(label3, BorderLayout.CENTER);
		createMenu.setName("create_menu");
		createMenu.addMouseListener(new PanelClickMouseListener(createMenu.getName()));
		contentPanelButtom.add(createMenu);
		
		JLabel label4 = new JLabel(icon4);
		JPanel allRecipes = new JPanel(new BorderLayout(0,0));
		allRecipes.setBackground(new Color(150,186,231));
		allRecipes.setBounds(createMenu.getWidth(), 0,  contentPanelButtom.getWidth()/2,  contentPane.getHeight()/2);
		allRecipes.setMinimumSize(new Dimension(213,125));
		//allRecipes.setBorder(new EmptyBorder(3, 3, 0, 0));
		allRecipes.add(label4, BorderLayout.CENTER);
		allRecipes.setName("all_recipes");
		allRecipes.addMouseListener(new PanelClickMouseListener(allRecipes.getName()));
		contentPanelButtom.add(allRecipes);
		
		contentPane.add(contentPanelTop);
		contentPane.add(contentPanelButtom);
		
		setContentPane(contentPane);
	}

}
