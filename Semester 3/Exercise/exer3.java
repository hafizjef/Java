import java.io.*;

class exer3
{
	public static void main (String args []) throws IOException
	{
		int engM=80, mathM=76, histM=93, geoM=58, artM=88; //Default value
		String eng, math, hist, geo, art;
		
		System.out.print("Please enter your mark for English : ");
		BufferedReader buffread = new BufferedReader(new InputStreamReader(System.in));
		eng= buffread.readLine(); //English mark input
		engM=Integer.parseInt(eng); //String to int
		
		System.out.print("Please enter your mark for Mathematics : ");
		math= buffread.readLine(); //Mathematics mark input
		mathM=Integer.parseInt(eng); //String to int
		
		System.out.print("Please enter your mark for History : ");
		hist= buffread.readLine(); //History mark input
		histM=Integer.parseInt(eng); //String to int
		
		System.out.print("Please enter your mark for Geography : ");
		geo= buffread.readLine(); //Geography mark input
		geoM=Integer.parseInt(eng); //String to int
		
		System.out.print("Please enter your mark for Art : ");
		art= buffread.readLine(); //Art mark input
		artM=Integer.parseInt(eng); //String to int
		
		int totalM=engM+mathM+histM+geoM+artM; //Formula to calculate total marks
		System.out.println("Total marks is : "+totalM+"/500"); //Display total marks
	}
}
