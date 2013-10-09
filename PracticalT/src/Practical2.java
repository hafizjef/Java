class Employee
{
	private String name;
	private double bonus;
	private double b_salary;
	public double total_salary;
	
	public static void main(String args[])
	{
		Employee obj = new Employee("Muhammad Ali",25.50,1500.00);
		obj.show();
		obj.calculate();
	}
	
		Employee (String n, double b, double s)
	{
		name = n;
		bonus = b;
		b_salary = s;
	}
	public double calculate()
	{
		total_salary=(bonus+b_salary);
		return total_salary;
	}
	
	public void show() 
	{
		
		System.out.println("\n\n Name : "+name);
		System.out.printf(" Bonus : %.2f", bonus);
		System.out.printf("\n Basic Salary : %.2f", b_salary);
		System.out.printf("\n Total salary : %.2f", calculate());
	}
}