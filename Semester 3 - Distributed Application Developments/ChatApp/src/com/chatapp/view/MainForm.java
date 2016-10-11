package com.chatapp.view;


import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MainForm extends JFrame {
	
	private JButton btnSendMsg = new JButton("Send");
	private JTextField textMsg = new JTextField();
	private JTextArea msgArea = new JTextArea();
	private JTextField ipAddr = new JTextField();
	private final JLabel ipLabel = new JLabel("IP");
	private JScrollPane scrollPane = new JScrollPane(msgArea);
	
	public MainForm() {
		
		this.setResizable(false);
		this.setTitle("Chat App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 486, 334);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		scrollPane.setBounds(10, 11, 361, 253);
		getContentPane().add(scrollPane);
		
		
		textMsg.setBounds(10, 275, 361, 20);
		getContentPane().add(textMsg);
		textMsg.setColumns(10);
		
		
		btnSendMsg.setBounds(381, 274, 89, 23);
		getContentPane().add(btnSendMsg);
		msgArea.setLineWrap(true);
		msgArea.setEditable(false);
		msgArea.requestFocusInWindow();
		

		msgArea.setBounds(10, 11, 361, 253);
		//getContentPane().add(msgArea);
		
		ipAddr.setBounds(381, 243, 89, 20);
		getContentPane().add(ipAddr);
		ipAddr.setColumns(10);
		ipAddr.setText("127.0.0.1");
		
		JLabel lblIpAddress = new JLabel("IP Address:");
		lblIpAddress.setBounds(381, 218, 89, 14);
		getContentPane().add(lblIpAddress);
		ipLabel.setBounds(381, 16, 89, 20);
		
		getContentPane().add(ipLabel);
		getRootPane().setDefaultButton(btnSendMsg);
	}
	
	public void showMessage(String message, String senderAdd) {
		msgArea.append("[" + senderAdd + "] " + message + "\n");
		// Set Scrollbar to bottom on new Message
		msgArea.setCaretPosition(msgArea.getDocument().getLength());
	}
	
	public String getMessage() {
		return textMsg.getText();
	}
	
	public String getIP() {
		return ipAddr.getText();
	}
	
	public void setIP(String ipAddr) {
		ipLabel.setText("IP: " + ipAddr);
	}
	
	public void addSendButton(ActionListener listenForSend) {
		btnSendMsg.addActionListener(listenForSend);
	}
	
	public void clear() {
		textMsg.setText(null);
	}
	
	public void showMessageBox(String message, String title, int type) {
		if (type == 0) {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
			
		} else if (type == 1) {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
			
		} else if (type == 2) {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
