import java.io.*;

public class Practical {

	public static void main(String[] args)throws IOException {
		int input1=0, input2=0;
		
		BufferedReader userin = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter Integer 1 : ");
		try{
			input1=Integer.parseInt(userin.readLine());
			}catch (NumberFormatException e){
			System.out.println("Invalid input, not integer number\nExit System\nThank You...");
			return;
		}
		
		System.out.print("Enter Integer 2 : ");
		try{
			input2=Integer.parseInt(userin.readLine());
			}catch (NumberFormatException e){
			System.out.println("Invalid input, not integer number\nExit System\nThank You...");
			return;
		}
		
		System.out.print("Enter Your Name : ");
		String name = userin.readLine();
		
		int total = input1+input2;
		
		System.out.println("Hi "+name+" ! The sum of "+input1+" and "+input2+" is "+ total+"\nThank you");

	}

}
