package co.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.gui.Constants;
import co.gui.RecipeImagePanel;
import co.utilities.ImageProcessing;

public class LoadRecipeImageButtonActionListener implements ActionListener {
	private RecipeImagePanel imagePanel;
	
	public LoadRecipeImageButtonActionListener(RecipeImagePanel imagePanel) {
		this.imagePanel = imagePanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser loadFile = new JFileChooser();
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		loadFile.setFileFilter(imageFilter);
		int rVal = loadFile.showOpenDialog(imagePanel);
		if(rVal == JFileChooser.APPROVE_OPTION) 
		{
			File file = loadFile.getSelectedFile();
			BufferedImage image = null;
			 
			try 
			{
				image = ImageIO.read(file);
				//imagePanel = new RecipeImagePanel(image);
				image = ImageProcessing.scaleImage(image, Constants.ImageWidth, Constants.ImageHeight);
				imagePanel.setImage(image);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				//textPane_Response.setText(e.getMessage());
				//tabbedPane.setSelectedComponent(tabbedPane.getComponent(1));
			}
		}
	}
}
