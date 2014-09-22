import java.io.*;

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
		System.out.println("Name : " + sname);
		System.out.println("History Mark : " + hmark);
		System.out.println("Math Mark : " + mmark);
		System.out.println("English Mark : " + engmark);
	}

	public static void main (String args[]){
		student John = new student("John", 80, 90, 100);
		John.showMark();
	}
}