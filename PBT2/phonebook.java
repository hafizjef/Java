import java.io.*;
public class phonebook
{
	public static void main(String[] args)throws IOException
	{
		saveNumber num1 = new saveNumber(50);

		int loc=0;
		int loop=0;
		while (loop<=3)
		{
			BufferedReader getInput = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("\nPlease input name"+"\t|"+(loc+1)+"|"+": ");
			String name = getInput.readLine();

			System.out.print("Please input tel no."+"\t|"+(loc+1)+"|"+": ");
			String telNo = getInput.readLine();

			System.out.print("\n");

			num1.setArrayElement(loc, name, telNo);
			loc+=1;
			loop+=1;
		}
		for (int x=0; x<4; x++)
		{
			num1.printArray(x);
		}

		num1.findByName(4, "Abu");
		
	}
}