/*
* Title  : Class Example
* Author : Hafiz Jefri
*/

class student{
	String sname;
	int hmark, mmark, engmark;


	public student(String name, int mark1, int mark2, int mark3){
		sname = name;
		hmark = mark1;
		mmark = mark2;
		engmark = mark3;
	}

	public void showMark(){
	System.out.println("\nName\t\t: " + sname);
		System.out.println("History Mark\t: " + hmark);
		System.out.println("Math Mark\t: " + mmark);
		System.out.println("English Mark\t: " + engmark);
	}

	public static void main (String args[]){
		student John = new student("John", 80, 90, 100);
		John.showMark();

		//example
		student Cupok = new student("Cupok", 10, 20, 30);
		student Sotong = new student("Sotong", 20, 30, 40);
		Cupok.showMark();
		Sotong.showMark();
	}
}
