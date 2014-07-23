class exl4
{
	public static void main(String args[])
	{
		int initTemp=Integer.parseInt(args[0]);
		int celsius=(initTemp-32)*5/9;
		
		System.out.println("The temp in Celsius is : "+celsius);
	}
}