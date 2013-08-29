import java.io.*;
class convert
{
//constructor name must have the same name as the class name
	float fah, cel;
	String result;
	
	convert(float fah)
	{
		cel=(fah-32)*5/9;
		result=String.format("%.1f", cel);
	}
	
	void show()
	{
		System.out.println("Temp in Celsius is : "+result+"C");
	}
}

class act3
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader stdin=new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Please enter the temp : ");
		String input=stdin.readLine();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		
		float fah=Integer.parseInt(input);
		
		convert obj=new convert(fah);
		obj.show();
		
	}
}