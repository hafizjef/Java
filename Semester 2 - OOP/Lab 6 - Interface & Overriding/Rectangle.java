/**
 *
 */
 
 import java.awt.Color;
 
 public abstract class Rectangle {
 
	private Color color;
	protected int width;
	protected int length;
	
	public Rectangle() {
	
		width = 10;
		length = 6;
	}
	
	public Rectangle(int width, int length) {
	
		this.width = width;
		this.length = length;
	}
	
	public Color getColor() {
	
		return color;
	}
	
	public void setColor(Color color) {
	
		this.color = color;
	}
	
	public int getWidth() {
	
		return width;
	}
	
	public void setWidth(int width) {
	
		this.width = width;
	}
	
	public int getLength() {
	
		return length;
	}
	
	public void setLength(int length) {
	
		this.length = length;
	}
	
	public void displayWidthLine() {

		System.out.print("\n+");

		for (int index = 0; index < getWidth(); index++)
			System.out.print("-");
			
		System.out.println("+");
		
		for (int index = 0; index < getLength(); index++) {
			
			System.out.print("|");
			for (int index2 = 0; index2 < getWidth(); index2++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
		
		System.out.print("+");

		for (int index = 0; index < getWidth(); index++)
			System.out.print("-");
		
		System.out.println("+");
	}
	
	public void draw() {
	
		System.out.println(getWidth() + " x " + getLength());
		System.out.print("\n+");

		for (int index = 0; index < getWidth(); index++){
			System.out.print("-");
		}
			
		System.out.println("+");
		
		for (int index = 0; index < getLength(); index++) {
			System.out.print("|");
			for (int index2 = 0; index2 < getWidth(); index2++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
		
		System.out.print("+");
		for (int index = 0; index < getWidth(); index++){
			System.out.print("-");
		}
		System.out.println("+");
	}

	public abstract int calculateArea();
}