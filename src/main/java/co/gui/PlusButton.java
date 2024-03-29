package co.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

//import org.apache.commons.io.IOUtils;

import co.gui.listeners.RemoveIngredientActionListener;
import co.logic.constants.IconPathConstant;

public class PlusButton extends JButton {

    public PlusButton(co.gui.IngredientPanel parentPanel) {
        setGraphicalProperties();
        //addActionListener(new RemoveIngredientActionListener(parentPanel, this)); //todo
    }

    private void setGraphicalProperties() {
        InputStream input;
        ImageIcon ic;
        try {
            input = new FileInputStream(IconPathConstant.PLUS_ICON_PATH);
            ic = new ImageIcon(ImageIO.read(input));
            super.setIcon(ic);

            Dimension size = new Dimension(ic.getIconWidth()+8, ic.getIconHeight());
            setPreferredSize(size);
            setMaximumSize(getPreferredSize());
            setMinimumSize(getPreferredSize());
            setContentAreaFilled(false);

            setFocusPainted(false);
            //UIManager.put("ToolTip.background",new ColorUIResource(255, 247, 200));
            //Font toolTipFont = new Font("Arial", Font.PLAIN, 12);
            //UIManager.put("ToolTip.font", toolTipFont);
            setToolTipText("Добавить новый ингредиент");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
