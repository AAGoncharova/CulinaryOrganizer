package co.gui.listeners;

import co.logic.DatabaseManager;
import co.logic.dao.Ingredient;
import co.logic.dao.IngredientType;
import co.utilities.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveNewIngredientButtonActionListener implements ActionListener {

    JFrame _newIngredientFrame;
    JTextField _ingredientName;
    JTextArea _ingredientDescription;
    JTextField _calorificValue;
    JComboBox<String> _ingredientType;

    public SaveNewIngredientButtonActionListener(JFrame frame, JTextField ingredientName, JTextArea ingredientDescription, JTextField calorificValue, JComboBox<String> ingredientType){
        _newIngredientFrame = frame;
        _ingredientName = ingredientName;
        _ingredientDescription = ingredientDescription;
        _calorificValue = calorificValue;
        _ingredientType = ingredientType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        saveNewIngredient();
        _newIngredientFrame.setVisible(false);
    }

    private void saveNewIngredient(){
        IngredientType ingType = DatabaseManager.getIngredientTypeByName((String)_ingredientType.getEditor().getItem());

        Ingredient ingredient = new Ingredient();
        ingredient.setName(_ingredientName.getText());
        ingredient.setDescription(_ingredientDescription.getText());
        String tmp = _calorificValue.getText();
        if(_calorificValue.getText() != null && !_calorificValue.getText().isEmpty())
            ingredient.setCalorificValue(Integer.parseInt(_calorificValue.getText()));
        ingredient.setIngredientType(ingType);

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        //s.persist(ingType);
        s.persist(ingredient);
        s.getTransaction().commit();
        s.close();
    }
}
