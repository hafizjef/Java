import java.text.*;
class ex1
{	
	public static void main (String args[])
	{
		
		int amount=200; //product amount
		double tax=0.06; //tax percentage
		
		double salestax=amount*tax;
		DecimalFormat df=new DecimalFormat ("#.00");
		System.out.println(df.format(salestax));
	}
}