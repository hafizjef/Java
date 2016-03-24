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
		Card card4 = new Card('D', "2");
		Card card5 = new Card('S', "King");
		Card card6 = new Card('S', "6");
		Card card7 = new Card('C', "8");
		Card card8 = new Card('C', "Queen");
		Card card9 = new Card('D', "4");

		// 1st player initialization
		Player[] players = new Player[3];
		Player p1 = new Player("Emma");

		
		p1.hit(card1);
		p1.calculateTotalPoint(card1);
		p1.hit(card2);
		p1.calculateTotalPoint(card2);
		p1.hit(card3);
		p1.calculateTotalPoint(card3);

	
		// initialize more player
		Player p2 = new Player("Ali");
		Player p3 = new Player("Abu");

		
		// add card to player 2 (Ali)
		p2.hit(card4);
		p2.calculateTotalPoint(card4);
		p2.hit(card5);
		p2.calculateTotalPoint(card5);
		p2.hit(card6);
		p2.calculateTotalPoint(card6);


		p3.hit(card7);
		p3.calculateTotalPoint(card7);
		p3.hit(card8);
		p3.calculateTotalPoint(card8);
		p3.hit(card9);
		p3.calculateTotalPoint(card9);
	
		// Put player in array
		players[0] = p1;
		players[1] = p2;
		players[2] = p3;

		// Print details of player
		for(int index = 0; index < players.length; index++) {  
			// Put current player into temporary object
			Player currentPlayer = players[index];
			int totalPoint = currentPlayer.getTotalPoint();


			// Display details of player
			System.out.print("Player " + (index + 1) + " : ");
			System.out.print(currentPlayer.getName());
			System.out.println("\t(Total Point : " + totalPoint + ")");
			currentPlayer.displayCardInHand();

		}


		//Calculate winner
		for (int index = 0; index < players.length; index++) {
		
			/* Eliminate players with more than 21 points */
			  
			if (players[index].getTotalPoint() > 21) {
				
				players[index] = null;
				continue;
			}
			
			if ((21 - players[index].getTotalPoint()) <= 3) {
			
				System.out.print("\n\n***Winner is Player " + (index+1));
				System.out.println(" : " +  players[index].getName());
				players[0] = players[index];
				continue;
			}
		}

	}	
}