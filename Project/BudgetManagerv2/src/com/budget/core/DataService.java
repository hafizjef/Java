package com.budget.core;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataService {
	static Logger v = new Logger(true);
	
	public static void initDB() {
		Connection conn = null;
		try{
			// initialise Database
			
			conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			
			statement.executeUpdate("drop table if exists BudgetAccount");
			statement.executeUpdate("drop table if exists Category");
			statement.executeUpdate("drop table if exists Account");
			statement.executeUpdate("drop table if exists Income");
			statement.executeUpdate("drop table if exists Expenses");
			
			statement.executeUpdate("create table BudgetAccount (budgetID INTEGER primary key, month TEXT, amount DOUBLE)");
			statement.executeUpdate("create table Category (month TEXT, category TEXT, allocatedBudget DOUBLE)");
			statement.executeUpdate("create table Account (accountID INTEGER primary key, initialBalance DOUBLE, currentBalance INTEGER)");
			statement.executeUpdate("create table Income (incomeID INTEGER primary key, amount DOUBLE, incomeDate DATE)");
			statement.executeUpdate("create table Expenses (expenseID INTEGER primary key, budgetID INTEGER, currentBalance DOUBLE, foreign key(budgetID) references Budget(budgetID))");
			
			
			statement.executeUpdate("insert into BudgetAccount Values (null, 'January', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'February', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'March', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'April', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'May', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'June', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'July', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'August', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'September', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'October', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'November', 1000.0)");
			statement.executeUpdate("insert into BudgetAccount Values (null, 'December', 1000.0)");
			
			
			// January Category;
			statement.executeUpdate("insert into Category Values ('January', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('January', 'Other', 0.0)");
			
			// February Category;
			statement.executeUpdate("insert into Category Values ('February', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('February', 'Other', 0.0)");
			
			// March Category;
			statement.executeUpdate("insert into Category Values ('March', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('March', 'Other', 0.0)");
			
			// April Category;
			statement.executeUpdate("insert into Category Values ('April', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('April', 'Other', 0.0)");
			
			// May Category;
			statement.executeUpdate("insert into Category Values ('May', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('May', 'Other', 0.0)");
			
			// June Category;
			statement.executeUpdate("insert into Category Values ('June', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('June', 'Other', 0.0)");
			
			// July Category;
			statement.executeUpdate("insert into Category Values ('July', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('July', 'Other', 0.0)");
			
			// August Category;
			statement.executeUpdate("insert into Category Values ('August', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('August', 'Other', 0.0)");
			
			// September Category;
			statement.executeUpdate("insert into Category Values ('September', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('September', 'Other', 0.0)");
			
			// October Category;
			statement.executeUpdate("insert into Category Values ('October', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('October', 'Other', 0.0)");
			
			// November Category;
			statement.executeUpdate("insert into Category Values ('November', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('November', 'Other', 0.0)");
			
			// December Category;
			statement.executeUpdate("insert into Category Values ('December', 'Car', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Food', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Grocery', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Household', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Personal', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Entertainment', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Bill', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Rent', 0.0)");
			statement.executeUpdate("insert into Category Values ('December', 'Other', 0.0)");
			
			
			v.Log("Database Initialised");
			
		} catch (SQLException err) {
			v.Log("186 " + err.getMessage());
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	  v.Log(err.getMessage());
	          }
		}
	}
	
	public static boolean saveBudget(String Month, String budgets[], String category[], String initialBalance){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
			
			PreparedStatement budgetStat = conn.prepareStatement("UPDATE BudgetAccount SET amount = ? where month = ?");
			budgetStat.setString(1, initialBalance);
			budgetStat.setString(2, Month);
			budgetStat.executeUpdate();
			
			for (int index=0; index < budgets.length; index++) {
				PreparedStatement stat = conn.prepareStatement("UPDATE Category SET allocatedBudget = ? where month = ? and category = ?");
				stat.setQueryTimeout(30);
				stat.setString(1, budgets[index]);
				stat.setString(2, Month);
				stat.setString(3, category[index]);
				stat.executeUpdate();
			}
			
			
			v.Log("DB Updated");
			return true;
			
		} catch (SQLException err) {
			v.Log("ERROR : " + err.getMessage());
			return false;
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	  v.Log("ERROR : " + err.getMessage());
	          }
		}
	}
	
	public static double[] getBudgets(String Month){
		Connection conn = null;
		double budgets[] = new double[9];
		int index = 0;
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
			
			PreparedStatement stat = conn.prepareStatement("SELECT allocatedBudget FROM Category where month = ?");
			stat.setString(1, Month);
			ResultSet rs = stat.executeQuery();
			while (rs.next()){
				v.Log("Budget " + index + " "  + rs.getDouble("allocatedBudget"));
				budgets[index] = rs.getDouble("allocatedBudget");
				index++;
			}
			
			return budgets;
			
		} catch (SQLException err) {
			v.Log("ERROR : " + err.getMessage());
			return budgets;
			
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	  v.Log("ERROR : " + err.getMessage());
	          }
		}
	}
	
	public static double getInitialBudget(String Month){
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
			
			PreparedStatement stat = conn.prepareStatement("SELECT amount FROM BudgetAccount where month = ?");
			stat.setString(1, Month);
			ResultSet rs = stat.executeQuery();
			
			return rs.getDouble(1);
			
		} catch (SQLException err) {
			v.Log("ERROR : " + err.getMessage());
			return 0;
			
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	  v.Log("ERROR : " + err.getMessage());
	          }
		}
	}
}
