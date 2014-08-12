import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;

public class WebServer {

  /**
   * WebServer constructor.
   */
  protected void start() {
    ServerSocket s;
	java.util.Date date = new java.util.Date();

    System.out.println("Port : 8080");
    System.out.println("(press CTRL-C to exit)");
    try {
      // create the main server socket
      s = new ServerSocket(8080);
    } catch (Exception e) {
      System.out.println("Error: " + e);
      return;
    }

    System.out.println("Listening for connection");
    for (;;) {
      try {
        // wait for a connection
        Socket remote = s.accept();
        // remote is now the connected socket
        //System.out.print("Connection, sending data.");
        BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
        PrintWriter out = new PrintWriter(remote.getOutputStream());

        // read the data sent. We basically ignore it,
        // stop reading once a blank line is hit. This
        // blank line signals the end of the client HTTP
        // headers.
       /*  String str=".";
        while (!str.equals(""))
          str = in.readLine();
		  System.out.println(""); */
		
		 
		
		String serv;
		System.out.println("\n---------------------------- "+ new Timestamp(date.getTime()) +" ---------------------------");
			while ((serv = in.readLine()) != null) {
				System.out.println(serv);
				if (serv.isEmpty()) {
					System.out.println("--------------------------------------------------------------------------------");
					break;
				}
			}
		
		String dataout = "00111100011100000011111001000110011101010110001101101011001000000011110001110101001111100101100101101111011101010011110000101111011101010011111000111100011000100111001000111110010001100111010101100011011010110010000001110100011010000110100101110011001111000110001001110010001111100100011001110101011000110110101100100000011101000110100001100001011101000011110001100010011100100011111001000110011101010110001101101011001000000111010001101000011001010010000000111100011000100011111001010101011011100110100101110110011001010111001001110011011001010011110000101111011000100011111000111100001011110111000000111110";
		String webprint = "";
		for (int i = 0; i < dataout.length()/8; i++) {
			int a = Integer.parseInt(dataout.substring(8*i,(i+1)*8),2);
			webprint += (char)(a);
		}
		
        // Send the response
        // Send the headers
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        // Send the HTML page
		out.write("<TITLE>Java Server</TITLE>");
        out.println("<H1>Hello world!</H2>");
		out.println(webprint);
        out.flush();
        remote.close();
      } catch (Exception e) {
        System.out.println("Error: " + e);
      }
    }
  }

  /**
   * Start the application.
   * 
   * @param args
   *            Command line parameters are not used.
   */
  public static void main(String args[]) {
    WebServer ws = new WebServer();
    ws.start();
  }
}