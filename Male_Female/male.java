import java.io.*;
class program
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("\nHello, please input 'M' for Male or 'F' for Female :");
		
		//Getting user input
		BufferedReader getchar = new BufferedReader (new InputStreamReader(System.in));
		String str;
		str = getchar.readLine();
		
		//Comparing user input
		if((str.equals("m")) || (str.equals("M")))
			System.out.println("\nYou are : Male");
		else if((str.equals("f")) || (str.equals("F")))
			System.out.println("\nYou are : Female");
		else{
			System.out.println("\nError! Wrong input");
			}
	
	}
}