package core.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import core.model.MainModel;
import core.views.MainView;

public class MainController {

	private MainView mainview = new MainView();
	private MainModel mainmodel = new MainModel();
	
	public MainController(MainView mainview, MainModel mainmodel){
		this.mainview = mainview;
		this.mainmodel = mainmodel;
		
		this.mainview.addClearButttonListener(new ClearListener());
		this.mainview.addSaveButtonListener(new SaveListener());
		
		this.mainview.addComboListener(new UpdateViewListener());
	}
	
	public void updateOnStart() {
		mainview.updateCategoryView(mainmodel.getBudgets("January"));
		mainview.updateInitialBudget(mainmodel.getInitialBudget("January"));
	}
	
	class UpdateViewListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				double value[] = mainmodel.getBudgets(e.getItem().toString());
				
				mainview.updateCategoryView(value);
				mainview.updateInitialBudget(mainmodel.getInitialBudget(e.getItem().toString()));
			}
		}
		
	}
	
	class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainview.clearCategoryValue();
		}
		
	}
	
	class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (mainmodel.saveBudget(mainview.getMonth(), mainview.getBudget(), 
				mainview.getCategory(), mainview.getInitialAmount())) {
				
				mainview.showMessage("Database Updated!", "Info", 0);
			} else {
				mainview.showMessage("Error accessing Database", "Error", 2);
			}
			
		}
		
	}
}
