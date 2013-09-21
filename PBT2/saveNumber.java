//import java.io.PrintWriter;
import java.io.*;
public class saveNumber{
	String name, telNo;
	String[] nameData, telData;

	/*public saveNumber(String telNo)throws IOException
	{
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("phonebook.txt", true)));
		writer.println(telNo);
		writer.close();
	}
	

	//save phoneNumber to a txt file
	void saveNumber(String telNo)throws IOException
	{
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("phonebook.txt", true)));
		writer.println(telNo);
		writer.close();
	}
	*/
	
	public saveNumber(int arrSize){
		nameData = new String[arrSize];
		telData = new String[arrSize];
	}
	public void setArrayElement(int loc, String name, String telNo){
		nameData[loc] = name;
		telData[loc] = telNo;
	}
	public void printArray(int loc){
		System.out.print(nameData[loc]+" : "+telData[loc]+" ");

	}


	public void findByName(int arrSize, String name){
		for (int x=0; x<arrSize; x++)
		{
			if (nameData[x].equals(name))
			{
				System.out.println("Found on index : "+x+" "+nameData[x]+" : "+telData[x]+" ");
			}
		}
	}
	
}