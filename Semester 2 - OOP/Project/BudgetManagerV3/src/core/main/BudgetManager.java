package core.main;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import core.controller.MainController;
import core.model.MainModel;
import core.views.MainView;;
public class BudgetManager {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		MainView view = new MainView();
		MainModel model = new MainModel();
		
		MainController controller = new MainController(view, model);
		
		
		view.setVisible(true);
		controller.updateOnStart();
		
		//model.initDB();
	}

}
