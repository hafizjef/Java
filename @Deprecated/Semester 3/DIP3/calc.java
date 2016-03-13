import java.io.*;

class calc
{
	public static void main (String[] args) throws IOException{
	BufferedReader getval = new BufferedReader (new InputStreamReader(System.in));
	System.out.print("Radius : ");
	String val1 = getval.readLine();
	System.out.print("Triangle Base : ");
	String val2 = getval.readLine();
	System.out.print("Triangle Height : ");
	String val3 = getval.readLine();
	
	//
	double rad = Integer.parseInt(val1);
	double tBase = Integer.parseInt(val2);
	double tHeight = Integer.parseInt(val3);
	
	double vCircle = areaCircle(rad);
	double vTriangle = areaTriangle(tBase, tHeight);
	System.out.println("Area of Circle : " + vCircle);
	System.out.println("Area of Triangle : " + vTriangle);
	System.out.println("Result : " + areaShaded(vTriangle, vCircle));
	
	}
	
	public static double areaCircle(double rad){
		return rad * rad * Math.PI;
	}
	
	public static double areaTriangle(double tBase, double tHeight){
		return 0.5 * tBase * tHeight;
	}
	
	public static double areaShaded(double minArea, double maxArea){
		return maxArea - minArea;
	}
}