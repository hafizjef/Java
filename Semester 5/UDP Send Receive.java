/*
* Title   : UDP Send And Receive Example
* Version : 1.0
* Author  : Hafiz Jefri
*/
import java.io.*;
import java.net.*;

public class chat{

	public static void main (String [] args)throws Exception{
		listenThread();
		sendThread();
	}
	
	public static void listenThread(){
		Thread receiveThread = new Thread(){
			public void run(){
				try{
				
					receiveMsg();
				}
				catch(Exception e){
					
				}
			}
		};
		receiveThread.start();
	}
	
	public static void sendThread(){
		Thread sendThread = new Thread(){
			public void run(){
				try{
				
					sendMsg();
				}
				catch(Exception e){
					
				}
			}
		};
		sendThread.start();
	}
	
	public static void sendMsg()throws Exception{
		
		DatagramSocket ds = new DatagramSocket (2021);
		InetAddress inet = InetAddress.getByName("localhost");
 
		 for(;;){
			BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
			System.out.print("Message : ");
 
			String msg = bf.readLine();
			byte [] buf = msg.getBytes();
 
			DatagramPacket dp = new DatagramPacket (buf, buf.length, inet, 2020);
			ds.send(dp);
 
			System.out.println("Message sent!");
		}
	}

	public static void receiveMsg()throws Exception{
		DatagramSocket ds = new DatagramSocket (2020);
		while(true)
		{
			byte [] buf = new byte [2000];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
 
			String msg = new String (buf);
			System.out.println("[" + dp.getAddress ().getHostName()+"] : "+msg.trim());
		}
	}
	
}