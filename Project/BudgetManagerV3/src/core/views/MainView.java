package core.views;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainView extends JFrame implements PropertyChangeListener {
	
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel budgetPanel = new JPanel();
	private JPanel expensePanel = new JPanel();
	private JPanel panelCategory = new JPanel();
	
	private JLabel budgetLabel = new JLabel("Remaining Budget : ");
	private JLabel budgetAmount = new JLabel("1000");
	private JLabel initialAmountLabel = new JLabel("Initial Amount : ");
	private JLabel monthLabel = new JLabel("Month :");
	
	private JComboBox<String> monthCBox = new JComboBox<String>();
	
	private JFormattedTextField initialBalance = new JFormattedTextField(NumberFormat.getNumberInstance());
	
	private JFormattedTextField carBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField foodBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField groceryBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField personalBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField entertainmentBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField billsBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField rentsBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField othersBudgetField = new JFormattedTextField(NumberFormat.getNumberInstance());
	
	private JLabel carBudgetLabel = new JLabel("Car :");
	private JLabel foodBudgetLabel = new JLabel("Foods :");
	private JLabel groceryBudgetLabel = new JLabel("Grocery :");
	private JLabel rentsBudgetLabel = new JLabel("Rents :");
	private JLabel personalBudgetLabel = new JLabel("Personal :");
	private JLabel entertainmentBudgetLabel = new JLabel("Entertainment :");
	private JLabel billsBudgetLabel = new JLabel("Bills :");
	private JLabel othersBudgetLabel = new JLabel("Others :");

	private JButton btnClear = new JButton("Clear");
	private JButton btnSave = new JButton("Save");

	
	public MainView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/image/favicon.png")));
		
		this.setResizable(false);
		this.setTitle("Budget Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panelCategory.setBounds(284, 11, 275, 300);
	    panelCategory.setBorder(BorderFactory.createTitledBorder("Category"));
	    budgetPanel.add(panelCategory);
	    panelCategory.setLayout(null);
		
		tabbedPane.setBounds(10, 11, 574, 350);
		tabbedPane.addTab("Budget", budgetPanel);
		tabbedPane.addTab("Expense", expensePanel);
		budgetPanel.setLayout(null);
		
		budgetLabel.setBounds(10, 11, 160, 14);
		budgetPanel.add(budgetLabel);
		
		budgetAmount.setFont(new Font("Tahoma", Font.BOLD, 26));
		budgetAmount.setBounds(20, 36, 200, 52);
		budgetPanel.add(budgetAmount);
		
		monthLabel.setBounds(10, 99, 46, 14);
		budgetPanel.add(monthLabel);
		
		monthCBox.setBounds(10, 124, 122, 20);
		budgetPanel.add(monthCBox);
		monthCBox.setModel(new DefaultComboBoxModel<String>(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", 
        		"September", "October", "November", "December"}));
		
		initialAmountLabel.setBounds(10, 155, 76, 14);
		budgetPanel.add(initialAmountLabel);
		
		
		initialBalance.setColumns(10);
		initialBalance.setValue(1000);
		initialBalance.setBounds(10, 180, 122, 20);
		initialBalance.addPropertyChangeListener("value", this);
		budgetPanel.add(initialBalance);
		
		
		// Category Panel
		
		carBudgetLabel.setBounds(10, 28, 46, 14);
		foodBudgetLabel.setBounds(10, 53, 46, 14);
		groceryBudgetLabel.setBounds(10, 78, 48, 14);
		rentsBudgetLabel.setBounds(10, 103, 60, 14);
		personalBudgetLabel.setBounds(10, 128, 51, 14);
		entertainmentBudgetLabel.setBounds(10, 153, 83, 14);
		billsBudgetLabel.setBounds(10, 178, 46, 14);
		othersBudgetLabel.setBounds(10, 203, 46, 14);
		
		panelCategory.add(foodBudgetLabel);
		panelCategory.add(carBudgetLabel);
		panelCategory.add(groceryBudgetLabel);
		panelCategory.add(rentsBudgetLabel);
		panelCategory.add(personalBudgetLabel);
		panelCategory.add(entertainmentBudgetLabel);
		panelCategory.add(billsBudgetLabel);
		panelCategory.add(othersBudgetLabel);
		
		carBudgetField.setColumns(10);
		foodBudgetField.setColumns(10);
		groceryBudgetField.setColumns(10);
		rentsBudgetField.setColumns(10);
		personalBudgetField.setColumns(10);
		entertainmentBudgetField.setColumns(10);
		billsBudgetField.setColumns(10);
		othersBudgetField.setColumns(10);
		
		carBudgetField.setValue(0);
		foodBudgetField.setValue(0);
		groceryBudgetField.setValue(0);
		rentsBudgetField.setValue(0);
		personalBudgetField.setValue(0);
		entertainmentBudgetField.setValue(0);
		billsBudgetField.setValue(0);
		othersBudgetField.setValue(0);
		
		carBudgetField.setBounds(143, 25, 122, 20);
		foodBudgetField.setBounds(143, 50, 122, 20);
		groceryBudgetField.setBounds(143, 75, 122, 20);
		rentsBudgetField.setBounds(143, 100, 122, 20);
		personalBudgetField.setBounds(143, 125, 122, 20);
		entertainmentBudgetField.setBounds(143, 150, 122, 20);
		billsBudgetField.setBounds(143, 175, 122, 20);
		othersBudgetField.setBounds(143, 200, 122, 20);
		
		carBudgetField.addPropertyChangeListener("value", this);
		foodBudgetField.addPropertyChangeListener("value", this);
		groceryBudgetField.addPropertyChangeListener("value", this);
		rentsBudgetField.addPropertyChangeListener("value", this);
		personalBudgetField.addPropertyChangeListener("value", this);
		entertainmentBudgetField.addPropertyChangeListener("value", this);
		billsBudgetField.addPropertyChangeListener("value", this);
		othersBudgetField.addPropertyChangeListener("value", this);
		
		panelCategory.add(carBudgetField);
		panelCategory.add(foodBudgetField);
		panelCategory.add(groceryBudgetField);
		panelCategory.add(rentsBudgetField);
		panelCategory.add(personalBudgetField);
		panelCategory.add(entertainmentBudgetField);
		panelCategory.add(billsBudgetField);
		panelCategory.add(othersBudgetField);
		
		btnClear.setBounds(176, 266, 89, 23);
		panelCategory.add(btnClear);
		
		btnSave.setBounds(10, 277, 89, 23);
        budgetPanel.add(btnSave);
		
		getContentPane().add(tabbedPane);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		Object source = evt.getSource();
		double tempBal = ((Number)initialBalance.getValue()).doubleValue();
		
		if (source == initialBalance){
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == carBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == foodBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == groceryBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		}  else if (source == personalBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == entertainmentBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == billsBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == rentsBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == othersBudgetField) {
			budgetAmount.setText(String.valueOf(getBalance(tempBal)));
		}
	}
	
	private double getBalance(double initialVal){
		double totalValue = ((Number)carBudgetField.getValue()).doubleValue() + ((Number)foodBudgetField.getValue()).doubleValue() + 
				((Number)groceryBudgetField.getValue()).doubleValue()  + ((Number)personalBudgetField.getValue()).doubleValue() + 
				((Number)entertainmentBudgetField.getValue()).doubleValue() + ((Number)billsBudgetField.getValue()).doubleValue() + 
				((Number)rentsBudgetField.getValue()).doubleValue() + ((Number)othersBudgetField.getValue()).doubleValue();
		
		return (initialVal - totalValue);
	}
	
	public void addClearButttonListener(ActionListener listenForClearBtn) {
		btnClear.addActionListener(listenForClearBtn);
	}
	
	public void addSaveButtonListener(ActionListener linstenForSaveBtn) {
		btnSave.addActionListener(linstenForSaveBtn);
	}
	
	public void addComboListener(ItemListener listenForCombo) {
		monthCBox.addItemListener(listenForCombo);
	}
	
	public String getMonth() {
		return monthCBox.getSelectedItem().toString();
	}
	
	public double[] getBudget() {
		double budgets[] = new double[8];
		
		budgets[0] = Double.parseDouble(carBudgetField.getValue().toString());
		budgets[1] = Double.parseDouble(foodBudgetField.getValue().toString());
		budgets[2] = Double.parseDouble(groceryBudgetField.getValue().toString());
		budgets[3] = Double.parseDouble(rentsBudgetField.getValue().toString());
		budgets[4] = Double.parseDouble(personalBudgetField.getValue().toString());
		budgets[5] = Double.parseDouble(entertainmentBudgetField.getValue().toString());
		budgets[6] = Double.parseDouble(billsBudgetField.getValue().toString());
		budgets[7] = Double.parseDouble(othersBudgetField.getValue().toString());
		
		return budgets;
	}
	
	public String[] getCategory() {
		String category[] = new String[] {"Car", "Food", "Grocery", "Rents", "Personal", "Entertainment", "Bills", "Other"};
		
		return category;
	}
	
	public void clearCategoryValue(){
		Component[] comp = panelCategory.getComponents();
		for (Component c : comp){
			if (c instanceof JFormattedTextField){
				((JFormattedTextField)c).setValue(0);
			}
		}
	}
	
	public double getInitialAmount(){
		return Double.parseDouble(initialBalance.getValue().toString());
	}
	
	public void showMessage(String message, String title, int type) {
		if (type == 0) {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
			
		} else if (type == 1) {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
			
		} else if (type == 2) {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void updateCategoryView(double value[]) {
		int index = 0;
		Component[] comp = panelCategory.getComponents();
		for (Component c : comp){
			if (c instanceof JFormattedTextField){
				((JFormattedTextField)c).setValue(value[index]);
				index++;
			}
		}
	}
	
	public void updateInitialBudget(double value) {
		initialBalance.setValue(value);
	}
}
