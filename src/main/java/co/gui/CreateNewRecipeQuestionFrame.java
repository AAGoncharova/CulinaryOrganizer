package co.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateNewRecipeQuestionFrame extends JFrame{
	
	public CreateNewRecipeQuestionFrame(String ingredientName) {
		JOptionPane pane = new JOptionPane("Ингредиент " + ingredientName + " отсутствует в базе данных." +
				"Он будет добавлен после сохранения рецепта. " + 
				"Хотите перейти к форме создания нового ингредиента " +
				"для указания дополнительных свойств?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
	}
	
}
