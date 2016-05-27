package com.budget.core;

public class Logger {
	private boolean logger = false;
	
	public Logger(boolean logger){
		this.logger = logger;
	}
	
	public void Log(String msg){
		if (logger) {
			System.out.println("[DEBUG] " + msg);
		}
	}
	
}
