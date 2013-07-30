//by HafizJef.
import java.io.*;
class atm
{
	public static void main(String args[]) throws IOException
	{
		String money;
		BufferedReader getinput = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\n\n+Welcome to Maybank2Mu berhad, This machine can spit out :\n\n\t| 10, 20, 50 and 100 |");
		System.out.println("\n\n+Please input amount of money that you want to withdraw(Min. RM 10) : ");
		
		money = getinput.readLine();
		
		int amount = Integer.parseInt(money), note100=0, note50=0, note20=0, note10=0;
		
		if (amount<10)
		{
			System.out.println("\n\nThe entered value is invalid");
		}
		else
			System.out.println("\n\nYou gonna withdraw RM "+amount+" from your account");
		
		
		if (amount>=100)
		{
			note100=amount/100;
			amount=amount%100;
		}
		if (amount>=50)
		{
			note50=amount/50;
			amount=amount%50;
		}
		if (amount>=20)
		{
			note20=amount/20;
			amount=amount%20;
		}
		if (amount>=10)
		{
			note10=amount/10;
			amount=amount%10;
		}
		
		System.out.println("\n\nNote $100\t= "+note100+"\nNote $50\t= "+note50+"\nNote $20\t= "+note20+"\nNote $10\t= "+note10);
	}
}
