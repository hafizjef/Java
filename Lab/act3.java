class Student
{
//constructor name must have the same name as the class name
	String name;
	int age;
	
	Student(String n,int a)
	{
		name = n;
		age = a;
	}
	Student()
	{
	}
	
	void show()
	{
		System.out.println("My name is "+name);
		System.out.println("My age is "+age);
	}
}

class act3
{
	public static void main(String args[])
	{
		Student obj=new Student("Dhia",24);
		obj.show();
		Student obj2=new Student(); //constructor overloading, more than one constructor in a class (refer class Student)
		obj2.show();
	}
}