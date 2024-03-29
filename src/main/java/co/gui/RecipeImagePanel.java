package co.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import co.utilities.ImageProcessing;

public class RecipeImagePanel extends JPanel {
	private BufferedImage image;

	public RecipeImagePanel(BufferedImage image) {
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.image = image;
		if(image != null)
			setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
		revalidate();
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
		if(image != null) {
			setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
			setMaximumSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
		}
		
		//revalidate();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		if(image != null) {
			//image = ImageProcessing.scaleImage(image, Constants.ImageWidth, Constants.ImageHeight);
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);  
		}        
    }
}
