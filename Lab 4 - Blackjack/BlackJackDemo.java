/**
 * 
 * 
 * @author: Hafiz Jefri
 */

public class BlackJackDemo {

	/**
	 * Main entry point of a program
	 */

	public static void main (String[] args) {

		System.out.println("\n\n\tThis is to demo Black Jack game");
		System.out.println("\t-------------------------------\n\n");
		
		Card card1 = new Card('H', "2");
		Card card2 = new Card('S', "9");
		Card card3 = new Card('C', "3");

		System.out.print(card1.getFaceValue() + "-");
		System.out.println(card1.getSymbol());
		System.out.print(card2.getFaceValue() + "-");
		System.out.println(card2.getSymbol());
		System.out.print(card3.getFaceValue() + "-");
		System.out.println(card3.getSymbol());
		System.out.println();

		// 1st player initialization
		Player p1 = new Player("John Cena");
		
		p1.hit(card2);
		p1.hit(card3);
		p1.hit(card1);

		System.out.format("Player %d: %s (Total Point: %d)%n", p1.getPlayerPos(), p1.getName(), p1.getTotalPoint());
		p1.displayCardInHand();
		System.out.println("\n");

		// initialize more player
		Player p2 = new Player("Emma Maembong");
		Player p3 = new Player("John Terry");
		Player p4 = new Player("Roberto Carlos");
		Player p5 = new Player("Johnny");
		
		// add card to player 2 (Emma Maembong)
		p2.hit(card1);
		p2.hit(card3);
		p2.hit(card1);

		System.out.format("Player %d: %s (Total Point: %d)%n", p2.getPlayerPos(), p2.getName(), p2.getTotalPoint());
		p2.displayCardInHand();

		System.out.println("\n\nTotal player: " + Player.playerCount);
	}
}