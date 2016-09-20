/**
*
*
*
*/

public class DemoCard {

	public static void main (String args[]){
		Card card1 = new Card('C', "King", 10, 6);
		Card card2 = new Card('D', "5", 5, 2);

		System.out.print("Card 1 : " + card1.getLength() + " x " + card1.getWidth());
		System.out.print("\t(Total Area is : " + card1.calculateArea() + ")");

		card1.draw();

		System.out.println();
		
		System.out.print("Card 2 : " + card2.getLength() + " x " + card2.getWidth());
		System.out.print("\t(Total Area is : " + card2.calculateArea() + ")");

		card2.draw();
	}
}