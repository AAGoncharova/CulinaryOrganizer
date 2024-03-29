package co.gui.listeners;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.Box;
import javax.swing.JPanel;

import co.gui.MinusButton;
//import co.utilities.Util;

public class MinusButtonVisibilityListener implements ComponentListener {
	
	private JPanel parentPanel;
	private MinusButton minusButton;
	private int minusButtonWidth;
	private Component box;
	
	public MinusButtonVisibilityListener(JPanel parentPanel, MinusButton minusButton, int minusButtonWidth) {
		this.parentPanel = parentPanel;
		this.minusButton = minusButton;
		this.minusButtonWidth = minusButtonWidth;
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		box = Box.createRigidArea(new Dimension(minusButtonWidth,0));
		//box = Box.createRigidArea(new Dimension(minusButton.getPreferredSize().width,0));
		parentPanel.add(box);
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		//int boxIndex = Util.getComponentIndex(box);
		//parentPanel.remove(boxIndex);
		parentPanel.remove(box);
		parentPanel.revalidate();
	}

}
