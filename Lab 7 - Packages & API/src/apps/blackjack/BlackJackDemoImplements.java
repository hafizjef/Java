/**
 * This class demonstrate the Object Oriented Programming using many objects
 * and class. This class acts as the game manager.
 * @author: Hafiz Jefri
 **/
package apps.blackjack;

import simplified.blackjack.Card;
import simplified.blackjack.Player;

public class BlackJackDemoImplements {

	/**
	 * Main entry point of a program
	 */

	public static void main (String[] args) {

		System.out.println("\n\n\tThis is to demo Black Jack game that uses" + 
			"Interfaces and Abstract class");
		System.out.println("\t---------------------------------------------" + 
			"--------------------------\n\n");
		
		// initialize new card
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
		Player[] players = new Player[4];
		Player p1 = new Player("Emma");
		p1.setLocation("Perak, Malaysia");

		//add card to player 1
		p1.hit(card1);
		p1.calculateTotalPoint(card1);
		p1.hit(card2);
		p1.calculateTotalPoint(card2);
		p1.hit(card3);
		p1.calculateTotalPoint(card3);

	
		// initialize more player
		Player p2 = new Player("Ali");
		p2.setLocation("Denmark");

		Player p3 = new Player("Abu");
		p2.setLocation("Algeria");

		Player p4 = new Player("Madhu Taneja");
		p4.setLocation("Mumbai, India");

		
		// add card to player 2 (Ali)
		p2.hit(card4);
		p2.calculateTotalPoint(card4);
		p2.hit(card5);
		p2.calculateTotalPoint(card5);
		p2.hit(card6);
		p2.calculateTotalPoint(card6);

		// add card to player 3
		p3.hit(card7);
		p3.calculateTotalPoint(card7);
		p3.hit(card8);
		p3.calculateTotalPoint(card8);
		p3.hit(card9);
		p3.calculateTotalPoint(card9);

		p4.hit(card1);
		p4.calculateTotalPoint(card1);
		p4.hit(card2);
		p4.calculateTotalPoint(card2);
		p4.hit(card5);
		p4.calculateTotalPoint(card5);

		// Put player in array
		players[0] = p1;
		players[1] = p2;
		players[2] = p3;
		players[3] = p4;

		// Print details of player
		for(int index = 0; index < players.length; index++) {  
			// Put current player into temporary object
			Player currentPlayer = players[index];
			int totalPoint = currentPlayer.getTotalPoint();
			
			//calculate Alphabet
			currentPlayer.calculateAlphabet();

			// Display details of player
			System.out.print("Player " + (index + 1) + " : ");
			System.out.print(currentPlayer.getName() + " @ " + currentPlayer.getLocation());
			System.out.println(" (Total Point : " + totalPoint + ")");
			currentPlayer.displayAlphabetCounts();
		}


		// Calculate winner
		for (int index = 0; index < players.length; index++) {
		
			// Eliminate players with more than 21 points
			  
			if (players[index].getTotalPoint() > 21) {
				
				players[index] = null;
				continue;
			}


			// Check eligibility of players
			if (players[index].eligibility() == false){
				System.out.println("\n---> Player " + (index +1) + " " +
				 players[index].getName() + " is not eligible.");
				players[index] = null;
				continue;
			}
			
			if ((21 - players[index].getTotalPoint()) <= 3) {
			
				System.out.print("\n\n***Winner is Player " + (index+1));
				System.out.println(" : " +  players[index].getName());
				players[0] = players[index];

				card4.draw();
				card5.draw();
				card6.draw();

				continue;
			}
		}
		
		System.out.println("\nNumber of Players : " + Player.getNoOfPlayers());
		System.out.println("Number of cards used in this game : " + Card.getNoOfCards());
		System.out.println("This program is developed in Eclipse");
	}	
}