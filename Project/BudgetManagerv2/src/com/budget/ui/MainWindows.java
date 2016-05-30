package com.budget.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ResourceBundle;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.budget.core.DataService;
import com.budget.core.Logger;

@SuppressWarnings("serial")
public class MainWindows extends JPanel implements PropertyChangeListener  {
	
	
	Logger v = new Logger(true);
	
	//Values for the fields
    private double amount = 1000;
    private double tempBal;
	private JFrame frame;
	private NumberFormat amountFormat;
	private JComboBox<String> comboBox;
	private JTabbedPane tabbedPane;
	private JPanel panelExpenses;
	private JPanel panelCategory;
	private JLabel lblRemaining;
	
	private JFormattedTextField initialBal;
	private JFormattedTextField carBudgetField;
	private JFormattedTextField foodBudgetField;
	private JFormattedTextField groceryBudgetField;
	private JFormattedTextField houseBudgetField;
	private JFormattedTextField personalBudgetField;
	private JFormattedTextField entertainmentBudgetField;
	private JFormattedTextField billsBudgetField;
	private JFormattedTextField rentsBudgetField;
	private JFormattedTextField othersBudgetField;
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows window = new MainWindows();
					window.frame.setVisible(true);
					
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainWindows() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		initialize();	
	}
	
	private void initialize() {
		setUpFormats();
		
		
		// Main Frame
		frame = new JFrame("Budget Manager");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindows.class.getResource("/images/favicon.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        
		
		// Virtual Screen
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(Color.BLACK);
        tabbedPane.setBounds(10, 11, 574, 350);
        frame.getContentPane().add(tabbedPane);
        
        
        
        
        // Section : Panel
        JPanel panelBudget = new JPanel();
        tabbedPane.addTab("Budget", null, panelBudget, null);
        panelBudget.setLayout(null);
        
        panelExpenses = new JPanel();
        tabbedPane.addTab("Expense", null, panelExpenses, null);
        
        panelCategory = new JPanel();
        panelCategory.setBounds(284, 11, 275, 300);
        panelCategory.setBorder(BorderFactory.createTitledBorder("Category"));
        panelBudget.add(panelCategory);
        panelCategory.setLayout(null);
        // End Section
        
        
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
              int state = itemEvent.getStateChange();
              System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
              System.out.println("Item: " + itemEvent.getItem());
            }
          };
        
        comboBox = new JComboBox<String>();
        comboBox.setBounds(10, 124, 122, 20);
        panelBudget.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
        comboBox.addItemListener(itemListener);
        
        
        // Section : Button
        JButton btnSave = new JButton(ResourceBundle.getBundle("com.budget.ui.messages").getString("btnSave")); //$NON-NLS-1$ //$NON-NLS-2$
        btnSave.setBounds(10, 277, 89, 23);
        panelBudget.add(btnSave);
        
        JButton btnClearAll = new JButton(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.btnNewButton.text")); //$NON-NLS-1$ //$NON-NLS-2$
        panelCategory.add(btnClearAll);
        btnClearAll.setBounds(176, 266, 89, 23);
        // End Section
        
        
        // Section : Label
        JLabel lblNewLabel = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("lblInitial"));
        lblNewLabel.setBounds(10, 155, 76, 14);
        panelBudget.add(lblNewLabel);
        
        JLabel lblMonth = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblMonth.text"));
        lblMonth.setBounds(10, 99, 46, 14);
        panelBudget.add(lblMonth);
        
        JLabel lblCar = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblCar.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblCar.setBounds(10, 28, 46, 14);
        panelCategory.add(lblCar);
        
        JLabel lblFoods = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblFoods.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblFoods.setBounds(10, 53, 46, 14);
        panelCategory.add(lblFoods);
        
        JLabel lblGrocery = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblGrocery.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblGrocery.setBounds(10, 78, 48, 14);
        panelCategory.add(lblGrocery);
        
        JLabel lblHousehold = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblHousehold.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblHousehold.setBounds(10, 103, 60, 14);
        panelCategory.add(lblHousehold);
        
        JLabel lblPersonal = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblPersonal.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblPersonal.setBounds(10, 128, 51, 14);
        panelCategory.add(lblPersonal);
        
        JLabel lblEntertainments = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblEntertainments.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblEntertainments.setBounds(10, 153, 83, 14);
        panelCategory.add(lblEntertainments);
        
        JLabel lblBills = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblBills.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblBills.setBounds(10, 178, 46, 14);
        panelCategory.add(lblBills);
        
        JLabel lblRents = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblRents.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblRents.setBounds(10, 203, 46, 14);
        panelCategory.add(lblRents);
        
        JLabel lblOthers = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblOthers.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblOthers.setBounds(10, 228, 46, 14);
        panelCategory.add(lblOthers);
        
        JLabel lblRemainingBudget = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.lblRemainingBudget.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblRemainingBudget.setBounds(10, 11, 93, 14);
        panelBudget.add(lblRemainingBudget);
        
        lblRemaining = new JLabel(ResourceBundle.getBundle("com.budget.ui.messages").getString("mainPane.label.text")); //$NON-NLS-1$ //$NON-NLS-2$
        lblRemaining.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblRemaining.setBounds(36, 36, 200, 52);
        panelBudget.add(lblRemaining);
        // End Section
        
        
        
        // Section : Formatted TextField
        initialBal = new JFormattedTextField(amountFormat);
        initialBal.setBounds(10, 180, 122, 20);
        panelBudget.add(initialBal);
        initialBal.setValue(amount);
        initialBal.setColumns(10);
        initialBal.addPropertyChangeListener("value", this);
        
        carBudgetField = new JFormattedTextField(amountFormat);
        carBudgetField.setColumns(10);
        carBudgetField.setBounds(143, 25, 122, 20);
        panelCategory.add(carBudgetField);
        carBudgetField.setValue(0);
        carBudgetField.addPropertyChangeListener("value", this);
        
        foodBudgetField = new JFormattedTextField(amountFormat);
        foodBudgetField.setColumns(10);
        foodBudgetField.setBounds(143, 50, 122, 20);
        panelCategory.add(foodBudgetField);
        foodBudgetField.setValue(0);
        foodBudgetField.addPropertyChangeListener("value", this);
        
        groceryBudgetField = new JFormattedTextField(amountFormat);
        groceryBudgetField.setColumns(10);
        groceryBudgetField.setBounds(143, 75, 122, 20);
        panelCategory.add(groceryBudgetField);
        groceryBudgetField.setValue(0);
        groceryBudgetField.addPropertyChangeListener("value", this);
        
        houseBudgetField = new JFormattedTextField(amountFormat);
        houseBudgetField.setColumns(10);
        houseBudgetField.setBounds(143, 100, 122, 20);
        panelCategory.add(houseBudgetField);
        houseBudgetField.setValue(0);
        houseBudgetField.addPropertyChangeListener("value", this);
        
        personalBudgetField = new JFormattedTextField(amountFormat);
        personalBudgetField.setColumns(10);
        personalBudgetField.setBounds(143, 125, 122, 20);
        panelCategory.add(personalBudgetField);
        personalBudgetField.setValue(0);
        personalBudgetField.addPropertyChangeListener("value", this);
        
        entertainmentBudgetField = new JFormattedTextField(amountFormat);
        entertainmentBudgetField.setColumns(10);
        entertainmentBudgetField.setBounds(143, 150, 122, 20);
        panelCategory.add(entertainmentBudgetField);
        entertainmentBudgetField.setValue(0);
        entertainmentBudgetField.addPropertyChangeListener("value", this);
        
        billsBudgetField = new JFormattedTextField(amountFormat);
        billsBudgetField.setColumns(10);
        billsBudgetField.setBounds(143, 175, 122, 20);
        panelCategory.add(billsBudgetField);
        billsBudgetField.setValue(0);
        billsBudgetField.addPropertyChangeListener("value", this);
        
        rentsBudgetField = new JFormattedTextField(amountFormat);
        rentsBudgetField.setColumns(10);
        rentsBudgetField.setBounds(143, 200, 122, 20);
        panelCategory.add(rentsBudgetField);
        rentsBudgetField.setValue(0);
        rentsBudgetField.addPropertyChangeListener("value", this);
        
        othersBudgetField = new JFormattedTextField(amountFormat);
        othersBudgetField.setColumns(10);
        othersBudgetField.setBounds(143, 225, 122, 20);
        panelCategory.add(othersBudgetField);
        othersBudgetField.setValue(0);
        othersBudgetField.addPropertyChangeListener("value", this);
        // End Section
        
        
        
        // Section : Listener
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        btnSave.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		//DataService.initDB();
        		
        		String category[] = new String[] {"Car", "Food", "Grocery", "Household", "Personal", "Entertainment", "Bill", "Rent", "Other"};
        		String budgets[] = new String[9];
        		
        		
        		budgets[0] = carBudgetField.getText();
        		budgets[1] = foodBudgetField.getText();
        		budgets[2] = groceryBudgetField.getText();
        		budgets[3] = houseBudgetField.getText();
        		budgets[4] = personalBudgetField.getText();
        		budgets[5] = entertainmentBudgetField.getText();
        		budgets[6] = billsBudgetField.getText();
        		budgets[7] = rentsBudgetField.getText();
        		budgets[8] = othersBudgetField.getText();
        		
        		//if (DataService.saveBudget(comboBox.getSelectedItem().toString(), budgets, category, initialBal.getText())) {
        		//	JOptionPane.showMessageDialog(frame, "Budgets Updated!");
        		//} else {
        		//	JOptionPane.showMessageDialog(frame, "Error writing to database", "Error", JOptionPane.ERROR_MESSAGE);
        		//}
        		
        		DataService.getBudgets(comboBox.getSelectedItem().toString());
        	}
        });
        
        btnClearAll.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		Component[] comp = panelCategory.getComponents();
        		for (Component c : comp){
        			if (c instanceof JFormattedTextField){
        				((JFormattedTextField)c).setValue(0);
        			}
        		}
        	}
        });
        
        // End Section
        
	}
	

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object source = evt.getSource();
		tempBal = ((Number)initialBal.getValue()).doubleValue();
		
		if (source == initialBal){
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == carBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == foodBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == groceryBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == houseBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == personalBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == entertainmentBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == billsBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == rentsBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		} else if (source == othersBudgetField) {
			lblRemaining.setText(String.valueOf(getBalance(tempBal)));
		}
	}
	
	private void setUpFormats(){
		amountFormat = NumberFormat.getNumberInstance();
	}
	
	
	private double getBalance(double initialVal){
		double totalValue = ((Number)carBudgetField.getValue()).doubleValue() + ((Number)foodBudgetField.getValue()).doubleValue() + 
				((Number)groceryBudgetField.getValue()).doubleValue() + ((Number)houseBudgetField.getValue()).doubleValue() + 
				((Number)personalBudgetField.getValue()).doubleValue() + ((Number)entertainmentBudgetField.getValue()).doubleValue() + 
				((Number)billsBudgetField.getValue()).doubleValue() + ((Number)rentsBudgetField.getValue()).doubleValue() + 
				((Number)othersBudgetField.getValue()).doubleValue();
		
		v.Log("Total Value : " + totalValue);
		
		return (initialVal - totalValue);
	}
}
