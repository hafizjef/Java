import java.text.*;
class exer1
{	
	public static void main (String args[])
	{
		int amount=200; //purchase amount
		double tax=0.06; //tax percentage
		
		double salestax=amount*tax;
		DecimalFormat df=new DecimalFormat ("#.00");
		System.out.println("Sales Tax is : "+df.format(salestax));
	}
}

