import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class quikchat extends JFrame implements ActionListener
{
	private static JTextArea displayTA;
	private static JTextField msgTA, ipTF;
	private JButton sendBtn;

	public quikchat()
	{
		super("PUO Quick Message");

		Container c=getContentPane();
		c.setLayout(new FlowLayout());

		Font font = new Font("Verdana", Font.PLAIN, 11);

		displayTA=new JTextArea(14,29);
		displayTA.setEditable(false);
		displayTA.setFont(font);
		displayTA.setLineWrap(true);

		JScrollPane scroll = new JScrollPane (displayTA);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		msgTA=new JTextField("", 34);
		msgTA.setEditable(true);

		ipTF=new JTextField("192.168.1.1", 42);

		sendBtn=new JButton("SEND");


		sendBtn.addActionListener(this);
		c.add(ipTF);
		c.add(scroll);
		c.add(msgTA);
		c.add(sendBtn);

		setSize(375,320);
		setVisible(true);
		
	}

	public static void focusTextField() {
        	msgTA.requestFocusInWindow();
    }

    public void actionPerformed(ActionEvent e){
    	if (e.getSource()==sendBtn);
    	String msg = msgTA.getText();
    	String ipAdd = ipTF.getText();
    	try{
    		sendMsg(msg, ipAdd);
    		displayTA.append("[Me] : " + msg+"\n");
    		msgTA.setText("");
    	}
    	catch (Exception ex){

    	}
    }

	public static void main(String args[]){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){
			e.printStackTrace();
		}
		quikchat ii=new quikchat();
		listenThread();
		quikchat.focusTextField();
		ii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void sendMsg(String msg, String ipAdd)throws Exception{
    		DatagramSocket ds = new DatagramSocket (2021);
			InetAddress inet = InetAddress.getByName(ipAdd);
			byte [] buf = msg.getBytes();
			DatagramPacket dp = new DatagramPacket (buf, buf.length, inet, 2020);
			ds.send(dp);
			ds.close();
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
