package com.chatapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.chatapp.view.MainForm;

public class UDPServer {
	
	private MainForm form = new MainForm();
	
	public UDPServer (MainForm form) {
		this.form = form;
		this.form.addSendButton(new SendMessage());
	}
	
	
	public Thread receiveThread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Thread is running");
			final DatagramSocket listenerSock;
			
			try {
				
				listenerSock = new DatagramSocket(8888);
				
				byte [] arrBuffer = new byte[1024];
				DatagramPacket rDataPacket = new DatagramPacket(arrBuffer, arrBuffer.length);
				
				while(true) {
					listenerSock.receive(rDataPacket);
					
					//arrBuffer = rDataPacket.getData();
					String strWord = new String(rDataPacket.getData(), 0, rDataPacket.getLength());
					
					form.showMessage(strWord, rDataPacket.getAddress().getHostAddress().toString());
					
				}
				
			} catch (IOException e1) { 
				
				form.showMessageBox(e1.getMessage(), "Error", 2);
			}
			System.out.println("Thread exit");
		}
		
	});
	
	
	public void setIP() throws UnknownHostException {
		form.setIP(InetAddress.getLocalHost().getHostAddress().toString());
	}
	
	public void sendMessage(String Message, String ipAddress) throws IOException {
		
		byte[] msgBuffer = new byte [1024];
		String msgToSend = Message;
		InetAddress sendToAdress = InetAddress.getByName(ipAddress);
		
		msgBuffer = msgToSend.getBytes();
		
		DatagramPacket varDP = new DatagramPacket(msgBuffer, msgToSend.getBytes().length, sendToAdress, 8888);
		
		DatagramSocket varDS = new DatagramSocket();
		varDS.send(varDP);
		
		System.out.println("Data sent!");
		varDS.close();
		form.showMessage(Message, InetAddress.getLocalHost().getHostName().toString());
	}
	
	class SendMessage implements ActionListener, KeyListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(form.getMessage().equals("") || form.getIP().equals("")) {
				form.showMessageBox("Message or IP cannot be Null", "Error", 2);
			} else {
				try {
					sendMessage(form.getMessage(), form.getIP());
					form.clear();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {

			if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
				if(form.getMessage().equals("") || form.getIP().equals("")) {
					form.showMessageBox("Message or IP cannot be Null", "Error", 2);
				} else {
					try {
						sendMessage(form.getMessage(), form.getIP());
						form.clear();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {}
	}
}
