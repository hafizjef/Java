package com.chatapp.main;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.chatapp.controller.UDPServer;
import com.chatapp.view.MainForm;

public class MyChatApp {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException {
		
		// Set UI Look and feel to WindowsLookAndFeel
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		
		MainForm form = new MainForm();
		form.setVisible(true);
		
		UDPServer server = new UDPServer(form);
		server.setIP();
		server.receiveThread.start();
		
	}
}
