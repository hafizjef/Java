class cons
{
	cons()
	{
		System.out.println("I'm automatically called immediately when the object is created before the new operator completes its job");
	}
}	

	class act2
	{
		public static void main(String args[])
		{
			cons obj = new cons();
		}
	}
