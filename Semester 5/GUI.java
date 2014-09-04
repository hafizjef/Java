import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Lab3Exe extends JFrame implements ActionListener
{
	private static JTextArea displayTA, msgTA;
	private JButton sendBtn;

	public Lab3Exe()
	{
		super("Chatting Box");

		Container c=getContentPane();
		c.setLayout(new FlowLayout());


		displayTA=new JTextArea(15,30);
		displayTA.setEditable(false);
		displayTA.setLineWrap(true);

		JScrollPane scroll = new JScrollPane (displayTA);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		msgTA=new JTextArea(2,24);
		sendBtn=new JButton("SEND");

		sendBtn.addActionListener(this);
		c.add(displayTA);
		c.add(scroll);
		c.add(msgTA);
		c.add(sendBtn);

		setSize(380,330);
		setVisible(true);
	}

    public void actionPerformed(ActionEvent e)

    {
    	if (e.getSource()==sendBtn);
    	//code goes here
    	String msg = msgTA.getText();
    	try{
    		sendMsg(msg);
    		displayTA.append("Me : " + msg+"\n");
    	}
    	catch (Exception ex){

    	}


    }

    public static void sendMsg(String msg)throws Exception{
    		DatagramSocket ds = new DatagramSocket (2021);
			InetAddress inet = InetAddress.getByName("10.48.44.116");
			//String msg = msgTA.getText();
			byte [] buf = msg.getBytes();
			DatagramPacket dp = new DatagramPacket (buf, buf.length, inet, 2020);
			ds.send(dp);
			ds.close();
    }

	public static void main(String args[])
	{
		Lab3Exe ii=new Lab3Exe();
		listenThread();
		ii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void receiveMsg()throws Exception{
		DatagramSocket ds = new DatagramSocket (2020);
		while(true)
		{
			byte [] buf = new byte [2000];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			String msg = new String (buf);
			displayTA.append("[" + dp.getAddress ().getHostName()+"] : "+msg.trim() + "\n");
		}
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
}