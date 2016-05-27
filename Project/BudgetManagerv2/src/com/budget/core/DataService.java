package com.budget.core;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataService {
	
	public static void initDB() {
		Logger v = new Logger(true);
		Connection conn = null;
		try{
			// initialise Database
			
			conn = DriverManager.getConnection("jdbc:sqlite:budget.db");
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			
			statement.executeUpdate("drop table if exists Budget");
			statement.executeUpdate("drop table if exists Account");
			statement.executeUpdate("drop table if exists Income");
			statement.executeUpdate("drop table if exists Expenses");
			
			statement.executeUpdate("create table Budget (budgetID INTEGER primary key, amount DOUBLE, category TEXT UNIQUE, month DATE)");
			statement.executeUpdate("create table Account (accountID INTEGER primary key, initialBalance DOUBLE, currentBalance INTEGER)");
			statement.executeUpdate("create table Income (incomeID INTEGER primary key, amount DOUBLE, incomeDate DATE)");
			statement.executeUpdate("create table Expenses (expenseID INTEGER primary key, budgetID INTEGER, currentBalance DOUBLE, foreign key(budgetID) references Budget(budgetID))");
			
			v.Log("Database Initialised");
			
		} catch (SQLException err) {
			v.Log(err.getMessage());
		}
		finally {
			try
	          {
	            if(conn != null)
	              conn.close();
	          } catch (SQLException err) {
	        	  v.Log(err.getMessage());
	          }
		}
	}
	
	public void doSome(){
		Logger v = new Logger(true);
		v.Log("doSome.method()");
	}
}
