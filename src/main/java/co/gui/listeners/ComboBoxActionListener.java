package co.gui.listeners;

import co.gui.IngredientPanel;
import co.gui.MinusButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxActionListener implements ItemListener {

    IngredientPanel parentPanel;
    MinusButton minusButton;
    private boolean isAlreadyAdded;

    public ComboBoxActionListener(IngredientPanel parentPanel, MinusButton minusButton) {
        this.parentPanel = parentPanel;
        this.minusButton = minusButton;
        isAlreadyAdded = false;
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        parentPanel.addIngredientPanel();
        minusButton.setVisible(true);
    }*/

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(!isAlreadyAdded) {
            parentPanel.addIngredientPanel();
            minusButton.setVisible(true);
            isAlreadyAdded = true;
        }
    }
}
