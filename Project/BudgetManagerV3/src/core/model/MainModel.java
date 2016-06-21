package core.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainModel {
	
	private String connectionURL = "jdbc:postgresql://localhost:5432/budget";
	private String userName = "postgres";
	private String password = "pass";
	
	Connection conn = null;
	
	public void initDB() {
		
		try{
			// initialise Database
			
			conn = DriverManager.getConnection(connectionURL, userName, password);
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			
			statement.executeUpdate("drop table if exists BudgetAccount CASCADE");
			statement.executeUpdate("drop table if exists Category");
			statement.executeUpdate("drop table if exists Account");
			statement.executeUpdate("drop table if exists Income");
			statement.executeUpdate("drop table if exists Expenses");
			
			statement.executeUpdate("create table BudgetAccount (budgetID SERIAL primary key, month TEXT, amount NUMERIC)");
			statement.executeUpdate("create table Category (catID SERIAL primary key, month TEXT, category TEXT, allocatedBudget NUMERIC)");
			statement.executeUpdate("create table Account (accountID SERIAL primary key, initialBalance NUMERIC, currentBalance INTEGER)");
			statement.executeUpdate("create table Income (incomeID SERIAL primary key, amount NUMERIC, incomeDate DATE)");
			statement.executeUpdate("create table Expenses (expenseID SERIAL primary key, budgetID INTEGER, currentBalance NUMERIC, foreign key(budgetID) references BudgetAccount(budgetID))");
			
			
			String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", 
											"October", "November", "December"};
			
			String category[] = {"Car", "Food", "Grocery", "Rents", "Personal", "Entertainment", "Bills", "Other"};
			
			
			
			for (int index = 0; index < 12; index++) {
				statement.executeUpdate("insert into BudgetAccount (month, amount) Values ('" + month[index] + "', 1000.0)");
			}
			
			
			for (int index = 0; index < 12; index++) {
				for (int index2 = 0; index2 < 8; index2++) {
					statement.executeUpdate("insert into Category (month, category, allocatedBudget) Values ('" + month[index] + "', '" + 
											category[index2] + "', 0.0)");
				}
			}
			
			
			System.out.println("Database Initialised");
			
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	  System.out.println(err.getMessage());
	          }
		}
	}
	
	public boolean saveBudget(String Month, double budgets[], String category[], double initialBalance){

		try {
			conn = DriverManager.getConnection(connectionURL, userName, password);
			
			PreparedStatement budgetStat = conn.prepareStatement("UPDATE BudgetAccount SET amount = ? where month = ?");
			budgetStat.setDouble(1, initialBalance);
			budgetStat.setString(2, Month);
			budgetStat.executeUpdate();
			
			for (int index=0; index < budgets.length; index++) {
				PreparedStatement stat = conn.prepareStatement("UPDATE Category SET allocatedBudget = ? where month = ? and category = ?");
				stat.setQueryTimeout(30);
				stat.setDouble(1, budgets[index]);
				stat.setString(2, Month);
				stat.setString(3, category[index]);
				stat.executeUpdate();
			}
			
			System.out.println("Success");
			return true;
			
		} catch (SQLException err) {
			System.out.println(err.getMessage());
			return false;
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	  System.out.println(err.getMessage());
	          }
		}
	}
	
	public double[] getBudgets(String Month){

		double budgets[] = new double[8];
		int index = 0;
		
		try {
			conn = DriverManager.getConnection(connectionURL, userName, password);
			
			PreparedStatement stat = conn.prepareStatement("SELECT allocatedBudget FROM Category where month = ?");
			stat.setString(1, Month);
			ResultSet rs = stat.executeQuery();
			while (rs.next()){
				System.out.println("Budget " + index + " "  + rs.getDouble("allocatedBudget"));
				budgets[index] = rs.getDouble("allocatedBudget");
				index++;
			}
			
			return budgets;
			
		} catch (SQLException err) {
			System.out.println("ERROR : " + err.getMessage());
			return budgets;
			
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	 System.out.println("ERROR : " + err.getMessage());
	          }
		}
	}
	
	public double getInitialBudget(String Month){
		
		try {
			conn = DriverManager.getConnection(connectionURL, userName, password);
			
			PreparedStatement stat = conn.prepareStatement("SELECT amount FROM BudgetAccount where month = ?");
			stat.setString(1, Month);
			ResultSet rs = stat.executeQuery();
			
			double result = 0; 
			
			while (rs.next()) {
				result =  rs.getDouble(1);
			}
			
			return result;
		} catch (SQLException err) {
			System.out.println("ERROR : " + err.getMessage());
			return 0;
			
		} finally {
			try
	          {
	            if (conn != null) {
	              conn.close();
	            }
	          } catch (SQLException err) {
	        	  System.out.println("ERROR : " + err.getMessage());
	          }
		}
	}
}
